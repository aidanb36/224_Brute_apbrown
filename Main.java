import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String argv[]) {
    testOne();
//  testTwo();
  }


  //--------------------------------------------------------
  // example of how to set up a testcase
  //
  // Frank    GEOG010  GEOG011
  // Cynthia  GEOG010
  // Walter                     GEOG101
  // George                     GEOG101  GEOG201
  //
  // here is the solution (size = 2):
  // Frank: GEOG010 GEOG011
  // George: GEOG101 GEOG201

  public static void testOne() {
    Instructor frank = new Instructor("Frank");
    String frankCourses[] = {"GEOG010", "GEOG011"};
    frank.teach(frankCourses);

    Instructor cynthia = new Instructor("Cynthia");
    String cynthiaCourses[] = {"GEOG010"};
    cynthia.teach(cynthiaCourses);

    Instructor walter = new Instructor("Walter");
    String walterCourses[] = {"GEOG101"};
    walter.teach(walterCourses);

    Instructor george = new Instructor("George");
    String georgeCourses[] = {"GEOG101", "GEOG201"};
    george.teach(georgeCourses);

    Instructor[] instructors = {frank, cynthia, walter, george};
    String[] courses = {"GEOG010", "GEOG011", "GEOG101", "GEOG201"};

    Instructor[] coverSet = findMinCover(courses, instructors);
    for (int i=0; i<coverSet.length; ++i)
      System.out.println(coverSet[i]);
  }

  //-----------------------------------------------------------------------
  // Write this testcase to mode the example from the assignment spec
  //
  // here's the unique solution (of size = 4):
  // John:  ART002 ART008 ART125
  // Betsy: ART124 ART125 ART201
  // Hiram: ART001 ART110 ART125
  // Ralph: ART008 ART064 ART205 ART266

  // public static void testTwo() {
  //   // fill this in

  //   Instructor[] coverSet = findMinCover(courses, instructors);
  //   for (int i=0; i<coverSet.length; ++i)
  //     System.out.println(coverSet[i]);
  // }

  //-----------------------------------------------------------------------

  public static Instructor[] findMinCover(String[] courses, Instructor[] instructors) {
    // implement this
    Instructor[] newbie = new Instructor[0];
      for(int i = 0; i<instructors.length; i++){
        System.out.print(instructors[i]);
      }
      return newbie;
  }

  //-----------------------------------------------------------------------

  public static ArrayList<boolean[]> permute(int n) {
    // implement this
    ArrayList<boolean[]> rtnval = new ArrayList<boolean[]>();
    if(n==0){
      boolean[] newbie = new boolean[0];
      rtnval.add(newbie);
    }
    else{
      ArrayList<boolean[]> sublist = permute(n-1);
      for (int e = 0; e<sublist.size(); ++e){
        boolean[] a1 = new boolean[n];
        a1 = sublist.get(e);
        a1[n-1] = true;
        rtnval.add(a1);
        boolean[] a2 = new boolean[n];
        a2 = sublist.get(e);
        a2[n-1] = false;
        rtnval.add(a2);
      }
    }
    return rtnval;
  }
}

