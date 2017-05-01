
package dbmanagement;


public class performa {
    private int studentId;
    private int testId;
    private int marks;
    private String response;
    private String remark;
    
    public void setData( student stdObj, test testObj , String response)
    {
        if(stdObj.getBatchAndDep() == testObj.getBatchAndDep())
        {
            this.studentId = stdObj.getStudentId();
            this.testId = testObj.getBatchAndDep();
            this.marks = 0;
            String answers = testObj.getAnswerScript();
            for(int i=0 ; i<response.length() ; i++)
            {
                if(response.charAt(i) == answers.charAt(i))
                {
                    this.marks++;
                }
            }
            this.remark = "PASS";
            if(this.marks < testObj.getPassMark())
            {
                this.remark = "FAIL";
            }   
        }
    }
    
    public void viewData()
    {
        System.out.println(this.studentId);
        System.out.println(this.testId);
        System.out.println(this.marks);
        System.out.println(this.response);
        System.out.println(this.remark);
    }
}
