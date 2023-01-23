# Optional - Instructions to run a Java Maven project globally

- Make the script executable by running the following command in the terminal:
  
    `chmod +x run_project.sh`
- Run the script by typing:

    `./g.sh`
- This script will change to the directory of the project, build it with Maven, and then run the main class specified.

### Making a script executable

- To make this script work globally, you can put it in a directory that is in the system's PATH and make sure the user running the script has the appropriate permissions to access and execute the file.

- To make a script executable, you can use the command:
  
    `chmod +x script_name.sh`
- This command will give the execute permission to the script. Note that, you need to have the appropriate permissions to make a file executable, otherwise you will get a permission denied error.
