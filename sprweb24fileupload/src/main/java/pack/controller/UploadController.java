package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
	public String abc(UploadFile uploadFile) {
		return "uploadform";
	}
	
	@PostMapping("/upload")
	public String submit(UploadFile uploadFile,
			Model model,
			BindingResult result) {//BindingResult : 에러를 알아서 잡아줌
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		// 업로드된 파일 검사
		MultipartFile file = uploadFile.getFile();
		String fileName = file.getOriginalFilename(); //우리가 선택한 파일네임
		
		if(result.hasErrors()) {
			return "err";
		}
		
		try {
			inputStream = file.getInputStream(); // 파일
			File newFile = new File("C:\\work2\\sprsou\\sprweb24fileupload\\src\\main\\resources\\static\\upload\\" + fileName);
			// 파일이 없어 그래야지 뉴파일이 되
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newFile); 
			int read = 0;
			byte[] bytes = new byte[1024];
			//자료가 있는 동안 읽어
			while((read = inputStream.read(bytes)) !=-1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (Exception e) {
			System.out.println("file submit err: " + e);
			return "err";
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		model.addAttribute("filename",fileName);
		return "uploadfile";
	}
}
