import java.io.*;

class Rectangle {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  //Declaring class variables
  private int left;
  private int bottom;
  private int width;
  private int height;

  /** 
  * Rectangle: Main Constructor
  * Pre: none
  * Post: Creates a rectangle from the parameter values
	* ensuring that width and height are non zero.
  */
  Rectangle(int left, int bottom, int width, int height) {
    this.left = left;
    this.bottom = bottom;
    this.width = width;
    if (width < 0) this.width = 0;
    this.height = height;
    if (height < 0) this.height = 0;
  }

  /** 
  * Rectangle: Constructor
  * Pre: none
  * Post: Creates a rectangle with all fields 0
  */
  Rectangle() {
    left = 0;
    bottom = 0;
    width = 0;
    height = 0;
  }

  /** 
  * Rectangle: Constructor
  * Pre: none
  * Post: Takes the properties from the passed in Rectangle r, and makes a copy
  * using the calling Rectangle
  */
  Rectangle(Rectangle r) {
    left = r.left;
    bottom = r.bottom;
    width = r.width;
    height = r.height;
  }

  /** 
  * Rectangle: Mutator Method (Setter)
  * Pre: none
  * Post: sets the values of the rectangle of object to the passed in values again ensuring non zero values
  */
  public void set(int left, int bottom, int width, int height){
    this.left = left;
    this.bottom = bottom;
    this.width = width;
    if (width < 0) this.width = 0;
    this.height = height;
    if (height < 0) this.height = 0;
  }

  /** 
  * Rectangle: toString Instance Method
  * Pre: none
  * Post: returns a nicely formatted string with the properties of the Rectangle
  */
  public String toString(){
    return String.format("base: (%d,%d) w: %d h: %d",this.left, this.bottom,this.width,this.height);
  }
  
  /** 
  * Rectangle: area Instance Method
  * Pre: none
  * Post: calculates and returns the area of the calling Rectangle object
  */
  public int area(){
    return this.width*this.height;
  }

  /** 
  * Rectangle: perimeter Instance Method
  * Pre: none
  * Post: Calculates and returns the perimeter of the calling Rectangle object
  */
  public int perimeter(){
    if(this.width == 0) return this.height;
    else if(this.height ==0) return this.width;
    else return 2*(this.width + this.height);
  }
  
  /** 
  * Rectangle: contains Instance Method
  * Pre: none
  * Post: checks if the calling Rectangle object contains the passed in Rectangle, returning true if it does and false if not
  */
  public boolean contains(Rectangle r){
    if((this.left <= r.left) && (this.bottom <= r.bottom) && ((this.width+this.left)>=(r.width+r.left)) && ((this.height + this.bottom)>=(r.height+r.bottom))) return true;
    else return false;
  }
  
  /** 
  * Rectangle: intersection Class Method
  * Pre: none
  * Post: returns the Rectangle formed by the area common to the two passed in Rectangles. If they do not intersect, returns a Rectangle with all fields set to 0.
  */
  public static Rectangle intersection(Rectangle r, Rectangle r1){
    if(!r.contains(r1)){
      int r_right = r.left + r.width;
      int r_top =  r.height + r.bottom;

      int r1_right = r1.left + r1.width;
      int r1_top =  r1.height + r1.bottom;

      int xL = Math.max(r.left, r1.left);
      int xR = Math.min(r_right, r1_right);
      
      if(xL > xR) return new Rectangle();
      else{
        int yB = Math.max(r.bottom, r1.bottom);
        int yT = Math.min(r_top, r1_top);
        if(yB > yT) return new Rectangle();
        else return new Rectangle(xL, yB, xR-xL, yT-yB);
      }
    }else return r1;
  }

  /** 
  * Rectangle: totalPerimeter Class Method
  * Pre: none
  * Post: returns the total perimeter, as an integer, of the figure formed by the two rectangles, only counting the portions that are on the edges of the exterior of the resulting figure. If one rectangle is completely contained by the other, the perimeter of the outer rectangle is returned, and if the rectangles do not intersect, the sum of the individual perimeters is returned.
  */
  public static int totalPerimeter(Rectangle r, Rectangle r1){
    Rectangle secR = Rectangle.intersection(r,r1);
    if(r.contains(r1)) return r.perimeter();
    else if(secR.left == 0 && secR.bottom == 0 && secR.width == 0 && secR.height == 0) return r.perimeter() + r1.perimeter();
    else if(secR.width == 0 || secR.height ==0) return r.perimeter() + r1.perimeter() - (secR.perimeter()*2);
    return  r.perimeter() + r1.perimeter() - secR.perimeter();
  }
  
  /** 
  * Rectangle: toFile Instance Method
  * Pre: none
  * Post: writes a nicely formatted output to Rectangle.txt
  */
  
  public void toFile(Rectangle r1){
    try{
      FileWriter fw= new FileWriter("Rectangles.txt");
      PrintWriter pw= new PrintWriter(fw);

      //print write rectangle A
      pw.println("Rectangle Class: \n");
      pw.printf("X coordinate Rectangle A: %d\t\t Y coordinate Rectangle A: %d\n\n", this.left, this.bottom);
      pw.printf("Width A: %d \t\t Height A: %d\n\n", this.width, this.height); 
      pw.printf("Area A: %d px^2 \t\t Perimeter A: %d px\n\n", this.area(), this.perimeter()); //calls area and perimeter methods to get the area and perimeter of the rectangle and prints to Rectangle.txt
      
      //print write rectangle B
      pw.printf("X coordinate Rectangle B: %d\t\t Y coordinate Rectangle B:%d\n\n", r1.left, r1.bottom);
      pw.printf("Width B: %d \t\t Height B: %d\n\n", r1.width, r1.height);
      pw.printf("Area B: %d px^2 \t\t Perimeter B: %d px\n\n", r1.area(), r1.perimeter()); //calls area and perimeter methods to get the area and perimeter of the rectangle and prints to Rectangle.txt

      pw.println("Intersection Rectangle of Rect. A & Rect. B: " + Rectangle.intersection(this,r1)); //calls intersection class method and prints the result to Rectangle.txt
      pw.println();
      pw.println("Total Perimeter for Both: "+ Rectangle.totalPerimeter(this,r1)+"px"); //calls the totalPerimeter class method and prints the result to Rectangle.txt
      
      pw.close();
    }catch (IOException e){}
  } 
}
