package Lab07_Part2;

public class Job {
    private int jobCode;
    private String jobDescription;
    private float payRate;
    private String payClass;

    public Job(){
    }

    public int getJobCode() {
        return jobCode;
    }

    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public String getPayClass() {
        return payClass;
    }

    public void setPayClass(String payClass) {
        this.payClass = payClass;
    }
}
