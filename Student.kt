package final

/*Constructor that takes in name, studentNumber, age, and address*/
class Student(
    private val name: String,
    private val studentNumber: String,
    private val age: Int,
    private val address: String
) {

  /*ArrayLists for stroing courses and grades*/
  private val grades: ArrayList<Double> = ArrayList<Double>()
  private val CourseAndGrade: ArrayList<String> = ArrayList<String>()

  /*Function that returns name*/
  fun getName(): String {
    return this.name
  }

  /*Function that returns StudentNumber*/
  fun getStudentNumber(): String {
    return this.studentNumber
  }

  /*Function that returns age*/
  fun getAge(): Int {
    return this.age
  }

  /*Function that returns address*/
  fun getAddress(): String {
    return this.address
  }

  /*Function that adds courses and grades to CourseAndGrade*/
  fun addCourseAndGrade(course: String, grade: Double) {
    grades.add(grade)
    CourseAndGrade.add("       Courses        Grades\n       $course          $grade")
  }

  /*Function that returns CourseAndGrade*/
  fun getCourseAndGrade(): ArrayList<String> {
    return this.CourseAndGrade
  }

  /*Function that returns grades*/
  fun getGrades(): ArrayList<Double> {
    return this.grades
  }
}
