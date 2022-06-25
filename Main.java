//Team Members
//1. Daniel Garami
//2. Lasya Erukulla
//Date Started: March 05, 2021
//Date Completed: March 11, 2021
/*
Brief Description: Using the Rectangle class, the program gets user input for the defining properties of a Rectangle object and outputs a nicely formatted text file that outputs various characteristics and features regarding each Rectangle object individually or together. Some of these examples include area, perimeter, whether or not they contain one another, the total perimeter of the two rectangles and more!
*/

import java.io.*;

class Main {

  public static void main(String[] args) {
    
  //declaring and intializizing two Rectangle objects
  Rectangle r1 = new Rectangle();
  Rectangle r2 = new Rectangle();
  
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //declaring arrays of integers with a length of 2 (one for each Rectangle)
  int[] x = new int[2];
  int[] y = new int[2]; 
  int[] width = new int[2]; 
  int[] height = new int[2]; 
  //declaring and initializing an array of booleans with a length of 2 and values of true
  boolean[] isValidLeft = {true, true}; 
  boolean[] isValidBottom = {true, true};
  boolean[] isValidWidth = {true, true};
  boolean[] isValidHeight = {true, true};

  //getting user input to later print to Rectangle.txt
  for(int i = 0; i < 2; i++){ //repeats the following twice
    System.out.printf("\nRectangle %d",i+1); //whatever index plus one (since zero indexed and we want to start at 1)

      do { //does the following
        try {
          System.out.print("\nEnter a left coordinate: "); //input prompt
          x[i] = Integer.parseInt(br.readLine()); //stores input
          isValidLeft[i] = true;
        } catch (IOException err) {
          System.out.println("Error...");
          isValidLeft[i] = false;
        } catch (NumberFormatException err) { //if input is not a number or contains decimals
          System.out.println("Error converting input...");
          System.out.println("Please make sure to enter an integer number!");
          isValidLeft[i] = false;
        }
      } while (!isValidLeft[i]);

      do { //does the following
        try {
          System.out.print("\nEnter a bottom coordinate: "); //input prompt
          y[i] = Integer.parseInt(br.readLine()); //stores input
          isValidBottom[i] = true;
        } catch (IOException err) {
          System.out.println("Error...");
          isValidBottom[i] = false;
        } catch (NumberFormatException err) { //if input is not a number or contains decimals
          System.out.println("Error converting input...");
          System.out.println("Please make sure to enter an integer number!");
          isValidBottom[i] = false;
        }
      } while (!isValidBottom[i]); //repeats while input is invalid

      do { //does the following
        try {
          System.out.print("\nEnter the width : "); //input prompt
          width[i] = Integer.parseInt(br.readLine()); //stores input
          isValidWidth[i] = true;    

          if(width[i] < 0){ //if width is less than 0
            System.out.println("Please enter a positive number!");
            isValidWidth[i] = false;
          }

        } catch (IOException err) {
          System.out.println("Error...");
          isValidWidth[i] = false;
        } catch (NumberFormatException err) { //if input is not a number or contains decimals
          System.out.println("Error converting input...");
          System.out.println("Please make sure to enter an integer number!");
          isValidWidth[i] = false;
        }
      } while (!isValidWidth[i]); //repeats while input is invalid
      
      do { //does the following
        try {
          System.out.print("\nEnter the height: "); //input prompt
          height[i] = Integer.parseInt(br.readLine()); //stores input
          isValidHeight[i] = true;    

          if(height[i] < 0){ //if height is less than 0
            System.out.println("Please enter a positive number!");
            isValidHeight[i] = false;
          }

        } catch (IOException err) {
          System.out.println("Error...");
          isValidHeight[i] = false;
        } catch (NumberFormatException err) { //if input is not a number or contains decimals
          System.out.println("Error converting input...");
          System.out.println("Please make sure to enter an integer number!");
          isValidHeight[i] = false;
        }
    } while (!isValidHeight[i]); //repeats while input is invalid
  }

  //setting the declared Rectangles objects to have the data gathered from user input
  r1.set(x[0],y[0],width[0],height[0]);
  r2.set(x[1],y[1],width[1],height[1]);
  
  //calling the toFile instance method to write the data gathered to Rectangle.txt
  r1.toFile(r2); 

    /*
    //Testing Intersection
    System.out.println("\nTESTING intersection:"); 
    Rectangle defaultR = new Rectangle(0,0,50,50);

    //Overlap on One Side (See PDF)
    Rectangle overlapOneSide = new Rectangle(12,-9,35,9);
    System.out.println("Overlap on One Side: " + Rectangle.intersection(defaultR,overlapOneSide)); //base: (12,0) w:35 h:0 

    //Overlap with a Line (See PDF)
    Rectangle overlapWithLine = new Rectangle(50,5,0,11);
    System.out.println("Overlap with a Line: " + Rectangle.intersection(defaultR,overlapWithLine)); //base: (50,5) w:0 h:11

    //Overlap Fully (See PDF)
    Rectangle defaultR2 = new Rectangle(defaultR);
    System.out.println("Same Size (Overlap Fully): " + Rectangle.intersection(defaultR,defaultR2)); //base: (0,0) w:50 h:50

    //Completely Contains (See PDF)
    Rectangle completelyContains = new Rectangle(0,0,25,25);
    System.out.println("Completely Contains : " + Rectangle.intersection(defaultR,completelyContains)); //base: (0,0) w:25 h:25

    //Completely Contains1 (NOT ON PDF)
    Rectangle completelyContains1 = new Rectangle(0,0,100,100);
    System.out.println("Completely Contains1 (NOT ON PDF): " + Rectangle.intersection(defaultR,completelyContains1)); //base: (0,0) w:50 h:50

    //Shifted Left (See PDF)
    Rectangle shiftedLeft = new Rectangle(-5,0,50,50);
    System.out.println("Same Size (Shifted Left): " + Rectangle.intersection(defaultR,shiftedLeft)); //base: (0,0) w:45 h:50

    //Shifted Right (See PDF)
    Rectangle shiftedRight = new Rectangle(5,0,50,50);
    System.out.println("Same Size (Shifted Right): " + Rectangle.intersection(defaultR,shiftedRight)); //base: (5,0) w:45 h:50 

    //Shifted Up (See PDF)
    Rectangle shiftedUp = new Rectangle(0,5,50,50);
    System.out.println("Same Size (Shifted Up): " + Rectangle.intersection(defaultR,shiftedUp)); //base: (0,5) w:50 h:45

    //Shifted Down (See PDF)
    Rectangle shiftedDown = new Rectangle(0,-5,50,50);
    System.out.println("Same Size (Shifted Down): " + Rectangle.intersection(defaultR,shiftedDown)); //base: (0,0) w:50 h:45

    //Random Overlap (NOT ON PDF)
    Rectangle randomOverlap1 = new Rectangle(-2,-2,4,3);
    System.out.println("Random Overlap1 (NOT ON PDF): " + Rectangle.intersection(defaultR,randomOverlap1)); //base: (0,0) w:2 h:1

    //Partial Overlap (See PDF)
    Rectangle partialOverlap = new Rectangle(0,-1,3,3);
    System.out.println("Partial Overlap: "+ Rectangle.intersection(randomOverlap1,partialOverlap)); //base: (0,-1) w:2 h:2

    //Single Dot (See PDF)
    Rectangle singleDot = new Rectangle(0,0,0,0);
    System.out.println("Single Dot: " + Rectangle.intersection(defaultR,singleDot)); //base: (0,0) w:0 h:0 

    //No Overlap (See PDF)
    Rectangle noOverlap = new Rectangle(-51,0,50,50); 
    System.out.println("No Overlap: " + Rectangle.intersection(defaultR,noOverlap)); //base: (0,0) w:0 h:0 

    //Negative Width (Cannot Visualize)
    Rectangle negativeWidth = new Rectangle(0,0,-50,50);
    System.out.println("Negative Width (NOT ON PDF): " + Rectangle.intersection(defaultR,negativeWidth)); //base: (0,0) w:0 h:50

    //Negative Length (Cannot Visualize)
    Rectangle negativeLength = new Rectangle(0,0,50,-50);
    System.out.println("Negative Length (NOT ON PDF): " + Rectangle.intersection(defaultR,negativeLength)); //base: (0,0) w:50 h:0

    //Random Overlap (NOT ON PDF)
    Rectangle randomOverlap = new Rectangle(12,-4,35,9);
    System.out.println("Random Overlap (NOT ON PDF): " + Rectangle.intersection(defaultR,randomOverlap)); //base: (12,0) w:35 h:5



    //Testing totalPerimeter
    System.out.println("\n\nTESTING totalPerimeter:"); 

    //Overlap on One Side (See PDF)
    System.out.println("Overlap on One Side: " + Rectangle.totalPerimeter(defaultR,overlapOneSide));  //(50 + 50 + 50 +50 + 9 + 9) = 218 px

    //Overlap with a Line (See PDF)
    System.out.println("Overlap with a Line: " + Rectangle.totalPerimeter(defaultR,overlapWithLine)); //(50 + 50 + 50 + 50) = 200 px

    //Overlap Fully (See PDF)
    System.out.println("Same Size (Overlap Fully): " + Rectangle.totalPerimeter(defaultR,defaultR2)); //(50 + 50 + 50 + 50) = 200 px

    //Completely Contains (See PDF)
    System.out.println("Completely Contains: " + Rectangle.totalPerimeter(defaultR,completelyContains)); //(50 + 50 + 50 + 50) = 200 px

    //Completely Contains1 (NOT ON PDF)
    System.out.println("Completely Contains1 (NOT ON PDF): " + Rectangle.totalPerimeter(defaultR,completelyContains1)); //(100 + 100 + 100 + 100) = 400 px

    //Shifted Left (See PDF)
    System.out.println("Same Size (Shifted Left): " + Rectangle.totalPerimeter(defaultR,shiftedLeft)); //(50 + 50 + 50 + 50 + 5 + 5) = 210 px

    //Shifted Right (See PDF)
    System.out.println("Same Size (Shifted Right): " + Rectangle.totalPerimeter(defaultR,shiftedRight)); //(50 + 50 + 50 + 50 + 5 + 5) = 210 px

    //Shifted Up (See PDF)
    System.out.println("Same Size (Shifted Up): " + Rectangle.totalPerimeter(defaultR,shiftedUp)); //(50 + 50 + 50 + 50 + 5 + 5) = 210 px

    //Shifted Down (See PDF)
    System.out.println("Same Size (Shifted Down): " + Rectangle.totalPerimeter(defaultR,shiftedDown)); //(50 + 50 + 50 + 50 + 5 + 5) = 210 px

    //Random Overlap (NOT ON PDF)
    System.out.println("Random Overlap1 (NOT ON PDF): " + Rectangle.totalPerimeter(defaultR,randomOverlap1)); //(50 + 50 + 50 + 50 + 2 + 2 + 2 + 2) = 208 px 

    //Partial Overlap (See PDF)
    System.out.println("Partial Overlap: "+ Rectangle.totalPerimeter(randomOverlap1,partialOverlap)); //(4 + 5 + 4 + 5) = 18 px 

    //Single Dot (See PDF)
    System.out.println("Single Dot: " + Rectangle.totalPerimeter(defaultR,singleDot)); //(50 + 50 + 50 + 50) = 200 px

    //No Overlap (See PDF)
    System.out.println("No Overlap: " + Rectangle.totalPerimeter(defaultR,noOverlap)); //([50 + 50 + 50 + 50] + [50 + 50 + 50 +50]) = 400 px

    //Negative Width (Cannot Visualize)
    System.out.println("Negative Width (NOT ON PDF): " + Rectangle.totalPerimeter(defaultR,negativeWidth)); //50 + 50 + 50 + 50) = 200 px

    //Negative Length (Cannot Visualize)
    System.out.println("Negative Length (NOT ON PDF): " + Rectangle.totalPerimeter(defaultR,negativeLength)); //50 + 50 + 50 + 50) = 200 px

    //Random Overlap (NOT ON PDF)
    System.out.println("Random Overlap (NOT ON PDF): " + Rectangle.totalPerimeter(defaultR,randomOverlap)); //(50 + 50 + 50 + 50 + 4 + 4) = 208 px
    */
  }
}