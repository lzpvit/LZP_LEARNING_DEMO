package ftp;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by LZP on 2017/8/2.
 */
public class FtpTest {
    public void testUpload(){
        FTPClient ftpClient = new FTPClient();
        FileInputStream fileInputStream = null;
        try {
            ftpClient.connect("127.0.0.1");
            boolean  a = ftpClient.login("LZHP","1234");
            if(a==true){
                System.out.println("login success..");
            }else {
                System.out.println("login failed..");
            }
            File srcFile = new File("D:/LZP.zip");
            System.out.println("connected....");
            fileInputStream = new FileInputStream(srcFile);
            ftpClient.changeWorkingDirectory("/LZP");
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("GBK");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.storeFile("1.zip",fileInputStream);
            fileInputStream.close();
            ftpClient.logout();
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("FTP客户端出错啦！",e);
        }finally {
           // IOUtils.closeQuietly(fileInputStream);
            try {
                ftpClient.disconnect();
            }catch (IOException e){
                e.printStackTrace();
                new RuntimeException("关闭FTP连接异常",e);
            }
        }
    }
    public void testDownload(){
        FTPClient ftpClient = new FTPClient();
        FileOutputStream fileOutputStream = null;
        try {
            ftpClient.connect("127.0.0.1");
            boolean t = ftpClient.login("LZHP","1234");
            if(t==true){
                System.out.println("login success..");
            }else{
                System.out.println("login failed...");
            }
            String downloadUrl = "/LZP/LZP.zip";
            fileOutputStream = new FileOutputStream("d:/LZHP.zip");
            ftpClient.setBufferSize(1024);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.retrieveFile(downloadUrl,fileOutputStream);
            fileOutputStream.close();
            ftpClient.logout();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
