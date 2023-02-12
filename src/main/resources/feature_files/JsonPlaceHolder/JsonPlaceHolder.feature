@JPlaceHolder2
Feature: JsonPlaceHolder

  @JPlaceHolder
  Scenario Outline: Get specific comment
    Given JsonPlaceHolder service is up and running
    When Get request is sent to get a specific comment with "<id>"
    Then Specific comment details with "<id>", "<name>", "<email>" is returned with status code of 200

    Examples:
      | id | name                                       | email                   |
      | 3  | odio adipisci rerum aut animi              | Nikita@garfield.biz     |
      | 4  | alias odio sit                             | Lew@alysha.tv           |
      | 20 | molestias expedita iste aliquid voluptates | Mariana_Orn@preston.org |


  @JPlaceHolder2
  Scenario Outline: Create a comment
    Given JsonPlaceHolder service is up and running
    When i create a new comment with "<postid>", "<name>", "<email>" and "<body>"
    Then Details with "<postid>", "<name>", "<email>" and "<body>" is returned with status code of 201

    Examples:
      | postid | name              | email                        | body
      | 1000   | Lateef Abdulsalam | lateef.abdulsalam@sydney.com | I like the post
      | 20     | Alice Abdulsalam  | aliceA@sydney.com            | I like the post very well
      | 80     | Peace Lateef      | peaceL@sydney.com            | I like the holiday