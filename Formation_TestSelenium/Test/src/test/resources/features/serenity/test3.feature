Feature: A random user uses Random.org

  Rule: test avec rules
    Background: ceci est un backgroud
      Given A random user goes to "https://random.org"

    Scenario Outline: Generate a random number by typing a min value greater than the max value
      When A random user sets the min value <min>
      And A random user clicks on the generate button
      Then A random user verifies if the max value input field is set at <max>
      * A random user verifies if the min value under the result shows <min1>
      * A random user verifies if the max value under the result shows <max1>
      * A random user verifies if the result number between <min2> and <max2> (included) is generated
      Examples:
        | min    | max    | min1        | max1        | min2 | max2 |
        | "5417" | "5418" | "Min: 5417" | "Max: 5418" | 5417 | 5418 |

    Scenario Outline: Roll some dices
      When A random user clicks on Allow selected for the cookies
      And A random user hovers the Games menu
      And A random user clicks on the Dice roller option
      Then A random user arrives on the Dice roller page
      When A random user selects <arg02> on the number of dices selector
      And A random user clicks on the Roll Dice button
      Then A random user verifies the sentence over the dice are <arg03>
      And A random user verifies there are <arg02> dices pictures shown
      Examples:
        | arg02 | arg03                |
        | 4     | "You rolled 4 dice:" |
        | 6     | "You rolled 6 dice:" |
        | 5     | "You rolled 5 dice:" |

      @run
    Scenario: Sort a list
      When A random user clicks on Allow selected for the cookies
      And A random user hovers the List & More menu
      And A random user clicks on the List & More option
      Then A random user arrives on the List page
      When A random user input in the text box
        | "nom1" | "michel1" |
        | "nom2" | "michel2" |
        | "nom3" | "michel3" |
        | "nom4" | "michel4" |
        | "nom5" | "michel5" |

  Rule: ceci n'est pas une règle
    Scenario Outline: Generate a random number by typing the max value
      Given A random user goes to "https://random.org"
      When A random user sets the max value <max>
      And A random user clicks on the generate button
      Then A random user verifies if the max value under the result shows <max1>
      And A random user verifies if the result number between <min> and <max2> (included) is generated
      Examples:
      | max  | max1      | min | max2 |
      | "58" | "Max: 58" | 1   | 58   |