package final

import java.util.*

fun main() {

  val input: Scanner = Scanner(System.`in`)

  back1@ while (true) {

    // Menu
    print("1) Make ClassRoom\n2) Exit Program\n\nEnter Choice: ")

    when (input.nextInt()) {
      1 -> {
        // creates classroom
        val classroom: ClassRoom = ClassRoom()

        back2@ while (true) {
          // Menu
          println()
          print("1) Add Student\n2) Print All Students\n3) Back\n4) Exit Program\n\nEnter Choice: ")

          when (input.nextInt()) {
            1 -> {
              // adds student
              println()
              classroom.addStudent()
              back3@ while (true) {
                // Menu
                println()
                print("1) Add Course\n2) Write Report\n3) Back\n4) Exit Program\n\nEnter Choice; ")

                when (input.nextInt()) {
                  1 -> {
                    // adds course
                    println()
                    classroom.addCourse()
                    continue@back3
                  }
                  2 -> {
                    // writes report
                    println()
                    classroom.writeReport()
                    continue@back3
                  }

                  // goes back/exits program
                  3 -> continue@back2
                  else -> break@back1
                }
              }
            }

            // prints all students
            2 -> classroom.printStudents()

            // goes back/exits program
            3 -> continue@back1
            else -> break@back1
          }
        }
      }

      // exits program
      else -> break@back1
    }
  }
}
