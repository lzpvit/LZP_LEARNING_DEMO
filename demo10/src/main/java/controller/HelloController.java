package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * Created by LZP on 2017/8/7.
 */
@Controller
public class HelloController  {
    @RequestMapping({"/hello","/"})
    public String hello(@RequestParam("userName") String userName){
        System.out.println(userName);
return "hello";
    }
    @RequestMapping("/he")
    public String he(){
        return "lzp";
    }
    @RequestMapping("/hello1")
    public String lzp2(String userName, Model model){
        model.addAttribute("userName",userName);
        System.out.println("model.."+userName);
        return "hello";
    }
@RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response){
if(!file.isEmpty()){
    try {
        FileOutputStream fileOutputStream = new FileOutputStream("/files/"+file.getOriginalFilename());
        InputStream in = file.getInputStream();
        int b = 0;
        while((b=in.read())!=-1){ //读取文件
            fileOutputStream.write(b);
        }
        fileOutputStream.flush(); //关闭流
        in.close();
        fileOutputStream.close();
    }catch (FileNotFoundException e){
e.printStackTrace();
    }catch (IOException e){
e.printStackTrace();
    }

}
        return "fileUploadSuccess";
}
@RequestMapping("/fileUpload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException{
String path = "D:/Temp/ideaFiles/"+file.getOriginalFilename();
    File file1 =new File(path);
    file.transferTo(file1);
return "fileUploadSuccess";
}
@RequestMapping("/fileUpload3")
    public String fileUpload3(HttpServletRequest httpServletRequest)throws IllegalStateException,IOException{
    CommonsMultipartResolver resolver =new CommonsMultipartResolver(httpServletRequest.getSession().getServletContext());
    if(resolver.isMultipart(httpServletRequest)){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)httpServletRequest;
        Iterator iterator  = multipartHttpServletRequest.getFileNames();
        while(iterator.hasNext()){
            MultipartFile file = multipartHttpServletRequest.getFile(iterator.next().toString());
            if(file!=null){
                String path ="D:/Temp/ideaFiles/"+file.getOriginalFilename();
                file.transferTo(new File(path));
            }
        }
    }
        return "fileUploadSuccess";
}
}
