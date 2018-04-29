package com.g.ds.trivial;


import java.util.*;

public class StudentAvarage {
    static class Student{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getMarks() {
            return marks;
        }

        public void setMarks(List<Integer> marks) {
            this.marks = marks;
        }

        private List<Integer> marks;
        public Student(String name,List<Integer> marks)
        {
            this.name=name;
            this.marks=marks;

        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", marks=" + marks +
                    '}';
        }
    }
    static class Record{
       private  String name;
       private  int marks;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }


        Record(String name,int marks)
        {
            this.name=name;
            this.marks=marks;
        }
    }
    public static void main(String[] args)
    {
        Record[] records = new Record[10];
        Record record1 = new Record("Charlise",78);
        Record record2 = new Record("Charlise",98);
        Record record3 = new Record("Jon",56);
        Record record4 = new Record("Jon",78);
        Record record5 = new Record("Remo",56);
        Record record6 = new Record("Remo",92);
        Record record7 = new Record("Spidy",70);
        Record record8 = new Record("Spidy",80);
        Record record9 = new Record("SuperMan",72);
        Record record10 = new Record("SuperMans",92);

        records[0]=record1;
        records[1]=record2;
        records[2]=record3;
        records[3]=record4;
        records[4]=record5;
        records[5]=record6;
        records[6]=record7;
        records[7]=record8;
        records[8]=record9;
        records[9]=record10;

        Map<String,Student> studentsMap = new HashMap<String,Student>();

        for(Record record : records)
        {
            if(!studentsMap.containsKey(record.getName()))
            {
                Student student = new Student(record.getName(),new ArrayList<Integer>());
                studentsMap.put(record.getName(),student);
            }
            studentsMap.get(record.getName()).getMarks().add(record.getMarks());
        }

        List<Student> studentList= new ArrayList(studentsMap.values());
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int student1Total=0;
                int student2Total=0;
                for(Integer marks:o1.getMarks())
                {
                    student1Total+=marks;
                }
                for(Integer marks:o2.getMarks())
                {
                    student2Total+=marks;
                }

                return student2Total-student1Total;
            }
        });

        Student s= studentList.get(0);
        int total=0;
        for(Integer marks:s.getMarks())
        {
            total+=marks;
        }

        System.out.println(s.getName()+" "+total);





    }
}
