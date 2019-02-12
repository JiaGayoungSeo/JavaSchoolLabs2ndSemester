package Lab06_Interface;

public class Project implements Comparable{
    private int projectNo;
    private String projectName;

    public Project(){}
    public Project(int projectNo, String projectName){
        setProjectNo(projectNo);
        setProjectName(projectName);
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
