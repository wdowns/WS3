package w3Solutions;

import java.io.*;
import java.util.Scanner;

/**
 *  The class creates an image in form of a greyscale image which is
 *  read in from a file. It contains methods to invert an image (dark
 *  goes to bright and vice versa), to rotate an image by 90 degree
 *  clockwise), and to convert an image to a black and white image.
 *
 *  @version 2015-10-19
 *  @author Manfred Kerber
 */
public class PGMImage{
    private int width;
    private int height;
    private int maxShade;
    private String typeOfFile;
    private short[][] pixels;

    /**
     *  @param filename The name of a file that contains an image in
     *  pgm format of type P2.
     *
     */
    public PGMImage(String filename) {
        // try since the file may not exist.
        try {
            // we read from the scanner s which is linked to the file filename.
            Scanner s = new Scanner(new File(filename));

            /* The field variables are assigned by reading in from a
               file. The file should start with something like
               P2
               150 176
               255

               where P2 is the file type, 150 the width of the image, 176
               the height, and 255 the maximal grey value. Then follow
               150*176 grey values between 0 and 255.
            */
    
            // We read the initial element that is in our case "P2"
            typeOfFile = s.next();
            // Next we read the width, the height, and the maxShade.
            width = s.nextInt();
            height = s.nextInt();
            maxShade = s.nextInt();
            //We initialize and read in the different pixels.
            pixels = new short[height][width];
            for (int i=0; i<height; i++){
                for (int j=0; j<width; j++) {
                    pixels[i][j] = s.nextShort();
                }
            }
            // We finished reading and close the scanner s.
            s.close();
        }
        catch (IOException e){
            //If the file is not found, an error message is printed,
            //and an empty image is created.
            System.out.println("File not found.");

            typeOfFile = "P2";
            width = 0;
            height = 0;
            maxShade = 0;
            pixels = new short[width][height];
        }
    }

    /**
     *  @return The width of the image.
     */
    public int getWidth(){
        return width;
    }

    /**
     *  @return The height of the image.
     */
    public int getHeight(){
        return height;
    }
    
    /**
     *  @return The maximal grey value of the image.
     */
    public int getMaxShade(){
        return maxShade;
    }

    /**
     *  @return The file type of the image.
     */
    public String getTypeOfFile(){
        return typeOfFile;
    }

    /**
     *  @return The matrix representing the pixels of the image.
     */
    public short[][] getPixels(){
        return pixels;
    }

    /**
     *  @return Average grey value of all pixels in the image.
     */
    public int averageGrey(){
        long sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sum += pixels[i][j];
            }
        }
        return (int) sum/(width * height);
    }
    
    /**
     *  The method inverts the image (dark goes to bright and vice versa).
     *  @param filename The filename of the file in which the inverted
     *  image should be saved.
     */
    public void invert(String filename) {
        // try since it may not be possible to write to filename.
        try {
            BufferedWriter out = 
                new BufferedWriter(new FileWriter(filename));
	
            // We write the file type to out.
            out.write(getTypeOfFile() + "\n");
	
            // We write the dimensions to out.
            out.write(getWidth() + " " + getHeight() +"\n");
	
            // We write the maximal element.
            out.write(getMaxShade() + "\n");
	
            // The inversion is computed that a grey value g is mapped to 255-g;
            // Every 15 values a newline is added to the file.
            byte counter = 0;
            for (int i=0; i<height; i++){
                for (int j=0; j< width; j++) {
                    out.write((255 - getPixels()[i][j]) + " ");
                    // The following lines do not change the picture. They only
                    // prevent the whole pictures being stored in a single line.
                    counter++;
                    if (counter == 15) {		 
                        out.write("\n");
                        counter = 0;
                    }
                }
            }
            out.write("\n");
            // We finished reading and close scanner s.
            out.close();
        }
        catch (IOException e){
            //Errors are caught.
            System.out.println("File not found.");
        }
    }
    
    /**
     *  The method rotates the image by 90 degrees clockwise.
     *  @param filename The filename of the file in which the rotated
     *  image should be saved.
     */
    public void rotate(String filename) {
        // try since it may not be possible to write to filename.
        try {
            BufferedWriter out = 
                new BufferedWriter(new FileWriter(filename));
	
            // We write the file type to out.
            out.write(getTypeOfFile() + "\n");
	
            // We write the dimensions to out.
            out.write(getHeight() + " " + getWidth() +"\n");
	
            // We write the maximal element.
            out.write(getMaxShade() + "\n");
	
            // Every 15 values a newline is added to the file.
            byte counter = 0;
            /*  Example a 2x4-matrix orig of the shape
             *  {{0, 1, 2, 3},
             *   {4, 5, 6, 7}}
             *  should be mapped to a 4x2-matrix
             *  {{4, 0},
             *   {5, 1},
             *   {6, 2},
             *   {7, 3}}
             *
             *  That is, the element orig[1][0] must be saved first to
             *  out, then orig[0][0]. I.e., we need to iterate first
             *  over the width, and then the height backward.
             *
             */
            for (int j=0; j< width; j++) {
                for (int i = height-1; i >= 0; i--){
                    out.write(getPixels()[i][j] + " ");
                    counter++;
                    if (counter == 15) {		 
                        out.write("\n");
                        counter = 0;
                    }
                }
            }
            out.write("\n");
            // We finished reading and close scanner s.
            out.close();
        }
        catch (IOException e){
            //Errors are caught.
            System.out.println("File not found.");
        }
    }
    
    /**
     *  The method converts the image to a black-and-white image and saves it to a file.
     *  @param filename The filename of the file in which the black-and-white
     *  image should be saved.
     */
    public void exportToP1(String filename) {
        // try since it may not be possible to write to filename.
        try {
            BufferedWriter out = 
                new BufferedWriter(new FileWriter(filename));

            // We write the file type to out.
            out.write("P1\n");
	
            // We write the dimensions to out.
            out.write(getWidth() + " " + getHeight() +"\n");
	
            // We write out "1" as the maximal element.
            out.write("1\n");
	
            // Every 15 values a newline is added to the file.
            byte counter = 0;
            int threshold = this.averageGrey();
            for (int i=0; i<height; i++){
                for (int j=0; j< width; j++) {
                    // If the pixel value is above the threshold we write 1, else 0.
                    if (getPixels()[i][j] > threshold) {
                        out.write("1 ");
                    } else {
                        out.write("0 ");
                    }
                    counter++;
                    if (counter == 15) {		 
                        out.write("\n");
                        counter = 0;
                    }
                }
            }
            out.write("\n");
            // We finished reading and close scanner s.
            out.close();
        }
        catch (IOException e){
            //Errors are caught.
            System.out.println("File not found.");
        }
    }

    /*
     * Some examples.
     */
    public static void main(String[] args) {
        PGMImage crest = new PGMImage("crest.pgm");
        crest.invert("crestInvert.pgm");
        crest.rotate("crestRotate.pgm");
        crest.exportToP1("crestBW.pgm");
        PGMImage small = new PGMImage("small.pgm");
        small.invert("smallInvert.pgm");
        small.rotate("smallRotate.pgm");
        small.exportToP1("smallBW.pgm");
    }
}
