# 📌 Overview
Deploy the OpenShift OKD 3.11 platform and integrate the deployment of a sample application using a microservices architecture (Simple_Microservice_QuizApp) to validate the platform's capability and stability for application deployment

# ⚙️ System architecture of OKD 3.11
OKD 3.11 component structure of the project:
+ Master node: Run API Server, Scheduler, Controller,..
+ Infrastructure node: Run router, registry, metrics, logging of system
+ Worker node: Run pods

Deployment on 3 EC2 on AWS platform. One node takes on the roles of Infrastructure Node and Worker Node
