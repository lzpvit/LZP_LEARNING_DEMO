import ftp.FtpTest;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

/**
 * Created by LZP on 2017/8/2.
 * ftp的文件上传与下载
 */
public class test6 {
    @Test
    public void test1(){
        FtpTest ftpTest = new FtpTest();
        ftpTest.testUpload();
    }
    @Test
    public void test2(){
        FtpTest ftpTest = new FtpTest();
        ftpTest.testDownload();
    }
}
