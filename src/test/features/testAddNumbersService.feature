Feature: Test Add Numbers Service

  Scenario Outline: Call AddNumbers API with valid params
    Given I add two numbers <Number1> and <Number2>
    Then Should return status OK and Result as <Total>

    Examples:
      | Number1 | Number2 | Total |
      | 2       | 3       |  5.0    |
      | 20.78       | -13       |  7.780000000000001    |
      | -56       | -33       |  -89.0    |
      | 1.56    | 4.01    | 5.57  |
      | 34567826.2356    | 5.76346676536E7    | 9.22024938892E7  |
      | -9.2024938892E6    | -5.76346676536E7    | -6.68371615428E7  |

  Scenario Outline: Call AddNumbers API with invalid params
    Given I add two numbers <Number1> and <Number2>
    Then Should return status <StatusCode>

    Examples:
      | Number1 | Number2 | StatusCode |
      | 2       |         | 404       |
      |         | -13     | 404        |
      | -56     | abc     | 404       |
      |         |         | 404        |