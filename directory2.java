import java.io.File;
import java.util.Scanner;

/*
 * Student name: Oluwajomiloju Okuwobi 
 * Student ID: 1002022767
 * Programming language used: Java 
 * Project title: Current Directory Size 
 * 
 * 
 * 
 * Pseudocode for Activity
 * 
 * long total
 * total = dirspace(".") the dot stands for the current directory i believe 
 * dirspace(targetdir)
 * long sum = 0 // needed to sum all the files in the directory and sub directory 
 * 
 * if entry is File:
 *      sum = sum + sizeof(entry)
 * if entry is Dir(exclude "." + ".."):
 *          sum = sum + dirspace(entry)
 * 
 * return Sum
 */

 class directory2 {
    
    
    //Tools I will need to perform this task: java.io.File

    public static long directory_Size(String curr_dir)
    {

       
        // declarations 
        File Directory = new File(curr_dir); // creating an instance of file 
        long Sum = 0; // will store the size of the directory. this is what the method will return 

        if(Directory.exists() && Directory.isDirectory())
        {
            System.out.println("The Directory: " + Directory.getAbsolutePath() + " Exists");
            System.out.println("Files and Subdirectories in Directory: ");
            System.out.println();
            File[] storage = Directory.listFiles(); // stores all the files in directory
            for(File f: storage)
            {
                System.out.println(f); // printing the content of files in the directory 
            }


            if (storage != null) // this block of code will not excecute unless storage is not empty. it will excecute if storage is not empty 
            {
                for(File f: storage)
                {
                    if(f.isFile())
                    {
                        Sum = Sum + f.length();
                    }
                    
                    // creating a recursive call 
                    if (f.isDirectory() && f.getName() != "." && f.getName()!= "..") 
                    {
                        System.out.println();
                        String path = f.getAbsolutePath();
                        if(path != null)
                        {
                            Sum = Sum + directory_Size(f.getAbsolutePath()); // getAbsolutePath Returns the absolute pathname string of this abstract pathname.
                        }
                        

                    }
                }
            }







        }

        else {
            System.out.println("Directory chosen does not exist");
        }


        return Sum;
    }



    // main part of the code. this will be used for testing the calculations from my method 
    public static void main(String[] args)
    {

        System.out.println();
        System.out.println("This program will calculate the directory size chosen by the user: ");
        System.out.println();


        // where excecution will take place
        System.out.println("Input directory: ");
        Scanner input = new Scanner(System.in);

        String target_directory = input.next();
        long total = directory_Size(target_directory);
        


        System.out.println();
        System.out.println("The Total size of files in bytes for " + target_directory +  " directory and its subdirectories is: " + total + " bytes");
        input.close();
        
    }


  

 }