package pojo;

import javax.persistence.*;

/**
 * Created by LZP on 2017/7/25.
 */
@Entity
@Table(name = "companyinfo")
public class CompanyInfo {
    private int id;
    private String nam;
    private String code;
    private String address;
    private String locationx;
    private String locationy;
    private String province;
    public CompanyInfo(){
    }
    public CompanyInfo(int id,String nam,String code,String address,String locationx,String locationy,String province){
        this.id=id;
        this.nam=nam;
        this.code=code;
        this.address=address;
        this.locationx=locationx;
        this.locationy=locationy;
        this.province=province;
    }
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    @Column(name = "nam")
    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }
@Basic
@Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
@Basic
@Column(name = "addresss")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
@Basic
@Column(name = "locationx")
    public String getLocationx() {
        return locationx;
    }

    public void setLocationx(String locationx) {
        this.locationx = locationx;
    }
@Basic
@Column(name = "locationy")
    public String getLocationy() {
        return locationy;
    }

    public void setLocationy(String locationy) {
        this.locationy = locationy;
    }
@Basic
@Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
