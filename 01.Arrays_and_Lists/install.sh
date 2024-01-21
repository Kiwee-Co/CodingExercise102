#!/usr/bin/env bash

brew install git maven sourcetree maven-completion eclipse-jee -y 

echo "checking out the materials.."

# setup git repo
mkdir -p ~/Projects/kiwee-co/
cd ~/Projects/kiwee-co/
git clone https://github.com/Kiwee-Co/Coding102.git
git clone https://github.com/Kiwee-Co/CodingExercise102.git

echo "github materials installed!"
brew cleanup -s --prune=all 

echo "All done!"

