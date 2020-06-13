# this is a guessing game that asks the users to guess any number till it matches with the computers number.

import random


def game():
    """A guessing game against the computer"""

    rng = random.Random()  # creates an object of the module random.
    number = rng.randrange(1, 1000)  # Get random numbers between 1 and 1000.

    guesses = 0
    msg = ""

    while True:
        num = int(input(msg + "\n Guess my number between 1 and 1000: "))
        guesses += 1

        if num > number:
            msg += str(num) + "is too high\n"

        elif num < number:
            msg += str(num) + "is too low\n"

        else:
            break

    input("\n\n Great! You got it in {0} guesses!".format(guesses))


print("Welcome to the guessing game.")
name = input("Enter your name: ")
print(name + " lets begin.")

game()
