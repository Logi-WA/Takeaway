# HBV202GFinalAssignment

## How to run

- To run this application we have mad a jlink (we decided to do that because our jar fil would not let us run javafx through  the jar file but that file can be found in the target directory) but to run the jlink you go [Here](target/Takeaway/bin/Takeaway-launcher) and run that file to run the project

## Frontend


- `src/main/java/is/vidmot` contains all the front end part of the project for futher detail of the classes :  [Markdown](src/site/markdown/markdown.md)

    - `ClientDialog.java` contains the dialog for user to register
    - `MenuView.java` loads the `menu-view.fxml` and puts the controller and root as well as it puts in the meals
    - `OrderController.java` controls the main part of the project
    - `PasswordController.java` takes in the password of a user
    - `PaymentController.java` controls the `payment-view.fxml`
    - `TakeAwayApplication.java` loads up the main part of the project
    - `View.java` store the views that we have to switch between
    - `ViewSwitcher.java` switches between the views that we hava stored in `View.java`

## Backend

- `src/main/java/is/vinnsla` contains all the front end part of the project for futher detail of the classes :  [Markdown](src/site/markdown/markdown.md)
    - `Cart.java ` contains all the information about what is in the cart and if something is added
    - `Customer.java` Contains the name of the customer as well as his address

    - `Meals.java` takes in the meal and the price of it
    - `Menu.java` allows you to add the meal to the display

## Testcases

- `src/test/java` contains a package that has an Alltests class that can perform all the test in the package
    - `is.vinnsla` contains all tests for the backend of the project
    - `is.vidmot` as we were instructed we did not make test cases for vidmot as the course did not teach  how we should test javafx

## Markdown

You can find the markdown here : [Markdown](src/site/markdown/markdown.md)

## License

- This project is licensed under the [MIT License](LICENSE). The MIT License allows for free use, modification,
  and distribution of this software, subject to the terms and
  conditions specified in the license.
