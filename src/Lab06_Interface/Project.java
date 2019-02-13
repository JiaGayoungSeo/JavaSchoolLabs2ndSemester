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
        Project project = (Project) o;
        if( project.getProjectNo ()>this.projectNo){
            return -1;
        }
        if(project.getProjectNo ()==this.projectNo){
            return 0;
        }
        else return 1;
    }
}
