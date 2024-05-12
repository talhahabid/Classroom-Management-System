package final

import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

class ClassRoom {

  private val input: Scanner = Scanner(System.`in`)

  // ArrayList for students
  private val students: ArrayList<Student> = ArrayList<Student>()

  /*Function that adds students to ArrayList*/
  fun addStudent() {

    /*Asks all the requirements to make student object*/
    print("Enter Student Name: ")
    val name: String = input.nextLine()

    print("Enter Student Number: ")
    val studentNumber: String = input.nextLine()

    print("Enter Student Age: ")
    val age: Int = input.nextInt()

    print("Enter Student Address: ")
    input.nextLine()
    val address: String = input.nextLine()

    // adds to ArrayList
    students.add(Student(name, studentNumber, age, address))
  }

  /*Private function that calculates average using recursion*/
  private fun calculateAverage(grades: ArrayList<Double>, n: Int): Double {

    // returns 0 if nothing else could be added
    return if (n == grades.size) {
      0.00
      // else adds grades and divides it by #of grades using recursion
    } else {

      (grades[n] / grades.size) + calculateAverage(grades, (n + 1))
    }
  }

  /*Function that adds course given the specific student number*/
  fun addCourse() {

    /*Asks for student number, course code, and final grade and adds it to the students properties*/
    print("Enter Students Number: ")
    input.nextLine()
    val studentNumber: String = input.nextLine()

    print("Enter Course Code: ")
    val course: String = input.nextLine()

    print("Enter Final Grade: ")
    val grade: Double = input.nextDouble()

    for (i in students) {
      if (i.getStudentNumber() == studentNumber) i.addCourseAndGrade(course, grade)
      break
    }
  }

  /*Function that prints all students in a classroom*/
  fun printStudents() {

    // makes an array and stores all the names in the classroom
    val arr = Array<String>(students.size) { _ -> "" }
    for (i in 0 until students.size) {
      arr[i] = students[i].getName()
    }
    // sorts array with bubbleSort
    val sortedArr = bubbleSort(arr)

    // prints sorted array
    for (i in sortedArr) {
      println(i)
    }
  }

  /*Private function that sorts given array (Bubble Sort)*/
  private fun bubbleSort(arr: Array<String>): Array<String> {

    for (i in 0 until arr.size - 1) {
      for (j in 0 until (arr.size - i - 1)) {
        if (arr[j] > arr[j + 1]) {
          val temp = arr[j]
          arr[j] = arr[j + 1]
          arr[j + 1] = temp
        }
      }
    }
    return arr
  }

  /*Function that writes a students personal and school information to file along with teachers comments*/
  fun writeReport() {

    // asks for student number and comments
    print("Enter Students Number: ")
    input.nextLine()
    val studentNumber: String = input.nextLine()

    print("Enter Comments: ")
    val comment: String = input.nextLine()

    /*Write info's to a student-named file*/
    for (i in students) {
      if (i.getStudentNumber() == studentNumber) {

        File(i.getName() + ".txt").bufferedWriter().use { out ->
          out.write(
              ("Name: ${i.getName()}     Age: ${i.getAge()}      Address: ${i.getAddress()}\n\n")
          )
          i.getCourseAndGrade().forEach { out.write("$it") }
          out.write(
              ("\nAverage: ${calculateAverage(i.getGrades(), 0).roundToInt()}\n\nComments:   $comment")
          )
        }
      }
    }
  }
}
