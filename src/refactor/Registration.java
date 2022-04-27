package refactor;

public class Registration {
    private String smsRegister = null;
    private String firstName = null;
    private String lastName = null;
    private String birthDate = null;
    private String address = null;
    private boolean isSuccessful = false;

    public Registration (){

    }

    public String getSmsRegister() {
        return smsRegister;
    }

    public void setSmsRegister(String smsRegister) {
        this.smsRegister = smsRegister;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}
