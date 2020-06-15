#!/usr/bin/env bash

pwd
ls -al

# install AWS SDK
pip install --user awscli
export PATH=$PATH:$HOME/.local/bin

# login to AWS ECR
eval $(aws ecr get-login --region eu-north-1)

# prepare docker image
export TAG=$(if [ "$TRAVIS_BRANCH" == "master" ]; then echo "latest"; else echo "$TRAVIS_BRANCH"; fi)
export IMAGE_NAME=$ECR/ci-cd-spring-boot
docker build -t $IMAGE_NAME:$TRAVIS_COMMIT .
docker tag $IMAGE_NAME:$TRAVIS_COMMIT $IMAGE_NAME:$TAG

# push image to the AWS ECR
docker push $IMAGE_NAME
