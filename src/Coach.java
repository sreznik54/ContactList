public class Coach extends Person{
    private String school;

    public Coach(String firstName, String lastName, String phoneNumber, String school){
        super(firstName, lastName, phoneNumber);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return super.toString() + " School: " + school;
    }
}
}
