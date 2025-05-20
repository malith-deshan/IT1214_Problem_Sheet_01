class Student{
  private int studentId;
  private String name;
  private int daysAttended;

  Student(int id, String name, int attend){
    studentId=id;
    this.name=name;
    daysAttended=attend;
  }

  public int getStudentId(){
        return studentId;
    }

    public String getName(){
        return name;
    }

    public int getDaysAttended(){
        return daysAttended;
    }

    public void setStudentId(int studentId){
        this.studentId=studentId;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDaysAttended(int daysAttended){
        this.daysAttended=daysAttended;
    }
}

class Classroom{
  Student[] students=new Student[10];
  int numStudents = 0;

  public void addStudent(Student student){
    if (numStudents<10){
      students[numStudents]=student;
      numStudents++;
    }
    else{
      System.out.println("Classroom is full");
    }
  }

  public void updateAttendance(int studentId, int days){
    for(int i=0; i<numStudents; i++){
      if(students[i].getStudentId()==studentId){
        students[i].setDaysAttended(days);
        return;
      }
    }
    System.out.println("Student ID "+studentId+" is not Exist");
    
  }

  public void displayAllStudents(){
    System.out.println("Student ID \t Name \t\t Days Attended");
    for(int i=0; i<numStudents; i++){
      System.out.println(students[i].getStudentId()+ "\t\t" + students[i].getName()+ "\t\t" + students[i].getDaysAttended());
    }
  }
}

class Main{
  public static void main(String[] args){
    Classroom classroom=new Classroom();

    Student s1=new Student(101, "Alice Smith", 12);
    Student s2=new Student(102, "Bob Jones", 15);
    Student s3=new Student(103, "Carol Lee", 10);

    classroom.addStudent(s1);
    classroom.addStudent(s2);
    classroom.addStudent(s3);
    
    classroom.updateAttendance(102, 16);
    classroom.updateAttendance(104, 5);

    classroom.displayAllStudents();

  }
}
