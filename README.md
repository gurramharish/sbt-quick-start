# SBT Commands

1. To launch sbt shell

    ```shell
    sbt
    ```
2. To run main class in the project in sbt shell

    ```shell
    run "Hello" "World"
   
    # Run command in project scope
    calculators/run 1213 1231
    
    # Run Main calls from Test folder using test scope
    calculators/Test/run
    ```

3. There are 2 scopes for sbt Project, Config, Task

4. Listing the projects

    ```shell
    projects
    ```

5. Switching between projects

    ```shell
    project calculators
    ```

6. Reload the changes made to build.sbt and project in sbt shell

    ```shell
    reload
    ```

7. Clean and compile project

    ```shell
    ;clean ;compile
    ```

8. To open scala console

   ```shell
   console
   
   # To open scala console for sub-project
   # to access classes in sub-project
   api/console
   ```

9. Running tests
   
   ```shell
   test
   
   # To keep watching for test file changes to rerun
   ~test
   ```

10. We can use ~ for executing any task and watching for changes

   ```shell
   ~compile
   
   ~clean
   
   ~run
   ```