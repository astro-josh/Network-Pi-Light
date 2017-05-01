# Network-Pi-Light
A java application utilizing jimbo's blinkt library and pi4j to create lighting effects on a raspberry pi and control over network.

IP address and socket are set on the client side.
Server side application can only be deployed on the raspberry pi using the pi4j library.

Strings are sent through a socket from the client to the server application on the raspberry pi which is then passed through a switch
statement to determine what command to run to produce the desired lighting effect.
