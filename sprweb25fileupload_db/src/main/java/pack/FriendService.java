package pack;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {

	@Autowired
	private FriendRepository friendRepository;
	
	public void saveFriend(Friend friend) {
		friendRepository.save(friend);
	}
	
	public List<Friend> findAll(){
		// Friend를 모두 읽어서 각 객체를 Bass64로 변환(사진만 Bass64로 변환됨) 후, 그 결과를 리스트에 저장함
		return friendRepository.findAll()
				.stream()
				.map(this::convertToBass64)
				.collect(Collectors.toList());
	}
	
	private Friend convertToBass64(Friend friend) {
		// 사진을 Bass64로 인코딩해서 문자열로 만들어줌(DB에 들어갈때 스트링으로 바껴서 들어감)
		if(friend.getSajin() != null && friend.getSajin().length >0) { //사진이 있음
			String bass64Image = Base64.getEncoder().encodeToString(friend.getSajin()); //이미지변경
			friend.setBase64Image(bass64Image);
		}
		
		return friend;
	}
	
	// bunho 증가
	private int generateBunho() {
		Integer lastBunho = friendRepository.findLastBunho();
		if(lastBunho == null) {
			return 1;
		}else {
			return lastBunho + 2;
		}
	}
}
