package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {

	@RequestMapping(path = "/upload-file")
	public String uploadFile() {
		return "upload-file"; // --> Trả vể tên định nghĩa trong tiles .xml
	}

	@RequestMapping(path = "/upload-file", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(name = "file") MultipartFile part, HttpServletRequest request, Model model) {
		String tapTin = part.getOriginalFilename();
		String thuMuc = request.getServletContext().getRealPath("/img/");

		try (OutputStream os = new FileOutputStream(thuMuc + tapTin)) {
			byte[] mb = part.getBytes();
			// InputStream in = part.getInputStream();

			os.write(mb);

		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("tapTin", tapTin);

		return "upload-file"; // --> Trả vể tên định nghĩa trong tiles .xml

	}

	
	
	
	/**
	 * 
	 * @return
	 */
	
	@RequestMapping(path = "/upload-multi-file")
	public String uploadFile2() {
		return "upload-file"; // --> Trả vể tên định nghĩa trong tiles .xml
	}
	
	@RequestMapping(path = "/upload-multi-file", method = RequestMethod.POST)
	public String uploadFile2(@RequestParam(name = "file") MultipartFile[] part, HttpServletRequest request,
			Model model) {
		List<String> tapTins = new ArrayList<String>();
		String thuMuc = request.getServletContext().getRealPath("/img/");
		for (String tapTin : tapTins) {
			try (OutputStream os = new FileOutputStream(thuMuc + tapTin)) {
				byte[] mb = tapTin.getBytes();
				// InputStream in = part.getInputStream();

				os.write(mb);

			} catch (IOException e) {
				e.printStackTrace();
			}
			tapTins.add(tapTin);
		}
		model.addAttribute("tapTins", tapTins);

		return "upload-file"; // --> Trả vể tên định nghĩa trong tiles .xml

	}
}
