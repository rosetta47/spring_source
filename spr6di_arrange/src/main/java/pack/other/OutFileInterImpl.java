package pack.other;

import java.io.FileWriter;

public class OutFileInterImpl implements OutFileInter{
	private String filepath; // 출력 파일을 경로 기억
	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public void outFile(String msg) {
		// 메세지를 파일로 출력
		try {
			FileWriter writer = new FileWriter(filepath);
			writer.write(msg);
			writer.close();
			System.out.println("파일 저장 완료! ");
		} catch (Exception e) {
			System.out.println("outFile err" + e);
		}
		
	}
}
