package pack;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import static com.mongodb.client.model.Filters.eq; 

public class MongoTest2 {

    static class Customer {
        private ObjectId id;
        private String name;
        private int age;
        private String gender;

        // 생성자에서 this.id = Id를 올바르게 설정
        public Customer(ObjectId id, String name, int age, String gender) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "id: " + id + ", name: " + name + ", age: " + age + ", gender: " + gender;
        }
    }

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";
        try (MongoClient client = MongoClients.create(uri)) {  // try-with-resources로 수정
            MongoDatabase db = client.getDatabase("test");
            MongoCollection<Document> collection = db.getCollection("customer");

            // 자료 추가
//            Document newData = new Document("name","관우").append("age", "26").append("gender", "남");
//            collection.insertOne(newData);
            
            // 수정 , 삭제를 위한 대상 자료 찾기
            // select * from customer where name='관우' limit=1;
            Document fCustomer = collection.find(eq("name", "관우")).first();
            if(fCustomer != null) {
            	ObjectId custId = fCustomer.getObjectId("_id");
            	
            	//자료 수정 (나이와 성별)
//            	collection.updateOne(eq("_id", custId),
//            			Updates.combine(Updates.set("age", "44"),Updates.set("gender", "남성"))
//            	);
//            	
//            	System.out.println("수정 성공");
            	
            	// 자료 삭제 
            	collection.deleteOne(eq("_id", custId));
            	System.out.println("삭제 성공");
            }else {
            	System.out.println("해당 이름의 자료는 없어요");
            }
            
            
            
            
            // 출력
            List<Customer> customers = new ArrayList<>();
            for (Document doc : collection.find()) {
                // age 필드가 Integer 또는 String일 수 있으므로 이에 대한 처리
                Object ageObj = doc.get("age");
                int age = 0;
                if (ageObj instanceof Integer) {
                    age = (Integer) ageObj;
                } else if (ageObj instanceof String) {
                    try {
                        age = Integer.parseInt((String) ageObj); // String을 integer로 변환
                    } catch (Exception e) {
                        System.out.println("invalid age format: " + ageObj);
                    }
                }

                // Customer 객체 생성
                Customer customer = new Customer(doc.getObjectId("_id"),
                        doc.getString("name"),
                        age,
                        doc.getString("gender"));

                customers.add(customer);
            }

            // Customer 목록 출력
            for (Customer cust : customers) {
                System.out.println(cust);
            }

            // 문서 건수 출력
            System.out.println("건수: " + collection.countDocuments());
        } catch (Exception e) {
            System.out.println("err: " + e);
        }
    }
}
