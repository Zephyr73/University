public class Person {
    protected String name;
    protected String ssn;
    protected String address;
    protected int age;
    protected String contact;

    public Person(String name, String ssn, String address, int age, String contact) {
        this.name = name;
        this.ssn = ssn;
        this.address = address;
        this.age = age;
        this.contact = contact;
    }
    public String getName() {
        return name;
    }
    public String getSsn() {
        return ssn;
    }
    public String getAddress() {
        return address;
    }
    public int getAge() {
        return age;
    }
    public String getContact() {
        return contact;
    }
}
