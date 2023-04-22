# HBV202GFinalAssignment

## Frontend

- `src/main/java/is/vidmot` contains all the front end part of the project
  - `ClientDialog.java` contains the dialog for user to register
  - `MenuView.java` loads the `menu-view.fxml` and puts the controller and root as well as it puts in the meals
  - `OrderController.java` controls the main part of the project
  - `PasswordController.java` takes in the password of a user 
  - `PaymentController.java` controls the `payment-view.fxml`
  - `TakeAwayApplication.java` loads up the main part of the project 
  - `View.java` store the views that we have to switch between
  - `ViewSwitcher.java` switches between the views that we hava stored in `View.java`

## Backend
- `src/main/java/is/vinnsla` contains all the front end part of the project
  - `Cart.java ` contains all the information about what is in the cart and if something is added
  - `Customer.java` Contains the name of the customer as well as his address
  - `Matsedill.java`


## Testcases

- `src/test/java` contains a package that has an Alltests class that can perform all the test in the package
   - `is.vinnsla` contains all tests for the backend of the project


## Markdown
You can find the markdown here : [Markdown](src/site/markdown/markdown.md)

## License
- [Contribution guidelines for this project](LICENSE)