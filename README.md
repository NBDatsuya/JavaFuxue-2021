# 讲课发言稿

___请用Typora或其他支持mermaid图表格式的MD应用打开___

```mermaid
classDiagram
    class Person{
        -id: int
        -name: String
        +getName()
        +getId()
    }
    class Student{
        -major: String
        +getMajor()
        +getLessons()
        +depositLesson(lesson: Lesson)
        +withdrawLesson(lesson: Lesson)
    }
    class Teacher{
        -phoneNumber: String
        +getPhoneNumber()
    }
    class Lesson{
        -id: int
        -name: String
        -type: String
        +getId()
        +getName()
        +getType()
    }
    class Test{
        -id: int
        -String time
        -fullScore: int
        +getId()
        +getTime()
        +getFullScore()
    }
    class LessonDatabase{
        +getLessonById()
        +getLessons()
        +addLesson(lesson: Lesson)
    }
    class StudentDatabase{
        +getStudentById()
        +getStudents()
        +addStudent(student: Student)
    }
    class TeacherDatabase{
        +getTeacherById()
        +getTeschers()
        +addTeacher(teacher: Teacher)
    }
    class DatabaseCountable{
        <<interface>>
        +getCountOfObject()
    }
    class SchoolSystem{
    
    }
    
    Person <|-- Student
    Person <|-- Teacher
    
    DatabaseCountable <|.. LessonDatabase
    DatabaseCountable <|.. TeacherDatabase
    DatabaseCountable <|.. StudentDatabase
    
    Lesson "1" <-- "1" Test: test
    
    Student "1" <-- "*" Lesson: lessons
    
    LessonDatabase "1" <-- "*" Lesson: lessons
    
    StudentDatabase "1" <-- "*" Student: students
    
    TeacherDatabase "1" <-- "*" Teacher: teachers
    
    SchoolSystem "1" <-- "1" LessonDatabase: lessonDatabase
    SchoolSystem "1" <-- "1" TeacherDatabase: teacherDatabase
    SchoolSystem "1" <-- "1" StudentDatabase: studentDatabase
    
    
```

