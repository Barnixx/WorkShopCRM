package pl.coderslab.model.employee;

public class Employee implements EmployeeDao {
    private int id;
    private String name;
    private String last_name;
    private String address;
    private String phone;
    private String note;
    private double man_hour;

    public Employee() {
    }

    public Employee(String name, String last_name, String address, String phone, String note, double man_hour) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.man_hour = man_hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getMan_hour() {
        return man_hour;
    }

    public void setMan_hour(double man_hour) {
        this.man_hour = man_hour;
    }

    @Override
    public String toString() {
        return "EmployeeServlet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                ", man_hour=" + man_hour +
                '}';
    }
}
