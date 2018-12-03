# 1. RabbitMQ

## 1.1 What's RabbitMQ 

A message broker, it acts as a middleman for various services. They can be used to reduce loads and delivery time 
by web application servers. 
RabbitMQ is an AMQP server. 

Message queueing allows web servers to respond to requests quickly instead of being forced to perform resource-heavy 
procedures on the spot. Message queueing is also good when you want to **distribute a message to multiple recipients** 
for consumption or for balancing loads between workers.

The consumer can take a message of the queue and start the processing of the PDF at the same time as the producer is 
queueing up new messages on the queue. The consumer can be on a totally different server than the publisher, 
or they can be located on the same server. The request can be created in one programming language and handled in 
another programming language - the two applications will only communicate through the messages they are sending to 
each other. Due to that, the two applications will have a low coupling between the sender and the receiver. 

