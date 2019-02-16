package Lab06_Interface;

import javax.naming.event.ObjectChangeListener;

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

    /* sort arrays by project number(int)
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
    */

    //sort arrays by project name(String)
    public int compareTo(Object o){
        Project project = (Project)o;

        return this.getProjectName().compareTo(project.getProjectName());

    }
}
