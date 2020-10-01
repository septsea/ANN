@echo off
cd ..
rd /q /s .git
git init
git add .
git commit -m "Update"
git branch -M main
git remote add origin git@github.com:septsea/ANN.git
git push -u --force origin main
pause
