Welcome to Github Action Trainings
===

Lab URL	https://digitallabs.palmeto.co.in

No    	Participant Name	            Username	Password
1	    Sreekanth, Chirigireddy	        BOA-Git01	P@lmeto@123
2	    Panneerselvam, Santhoshkumar	BOA-Git02	P@lmeto@123
3	    J, KRUTHIKA	                    BOA-Git03	P@lmeto@123
4		Subramanian, Aiswarya          	BOA-Git04	P@lmeto@123
5	    Kavin, J S	                    BOA-Git05	P@lmeto@123
6	    Kamalakannan, Bharathi	        BOA-Git06	P@lmeto@123
7	    Gowthaman, Hariprasath        	BOA-Git07	P@lmeto@123
8	    Senthilnathan, Chinniah         BOA-Git08	P@lmeto@123
9	    Uthayakumar, Vimalkumar(Vimal)	BOA-Git09	P@lmeto@123
10	    Panakkul, Shrijesh	            BOA-Git10	P@lmeto@123
11	    Bhave, Prasad                	BOA-Git11	P@lmeto@123
12	    Pravin X	                    BOA-Git12	P@lmeto@123
13	    Sumathi Shunmugavel	            BOA-Git13	P@lmeto@123
14	    Sachin P	                    BOA-Git14	P@lmeto@123
15	    Duraisubramanian Muthu	        BOA-Git15	P@lmeto@123
16	    Selvam, Rangith 	            BOA-Git16	P@lmeto@123
17	    K, Karunakaran	                BOA-Git17	P@lmeto@123
18	    Preetha D	                    BOA-Git18	P@lmeto@123
19	    Nayak, Ashisa K	                BOA-Git19	P@lmeto@123
20	    Periyasamy, Mahesh	            BOA-Git20	P@lmeto@123
21	    Gangaramani, Kamlesh K 	        BOA-Git21	P@lmeto@123
22	    Sanapiratti Ravi, Balaji 	    BOA-Git22	P@lmeto@123
23	    Shashanka Shekhar Mishra	    BOA-Git23	P@lmeto@123
24	    Saurabh Priyadarshi	            BOA-Git24	P@lmeto@123
25	    Sumera Shaik	                BOA-Git25	P@lmeto@123
26	    Sibtain Ali	                    BOA-Git26	P@lmeto@123
27	    Prasanth S	                    BOA-Git27	P@lmeto@123


Connect to lab
---

Poweron lab servers
---

Open vmware work station 
    ubuntu 01 -- power on virtual machine
    windows Server 2019 -- power on virtual machine

Connect to VM
---
open "VM login details" note pad

connect to ubuntu via putty
    hostname: your ubuntu ip from note pad
    user name and password from note pad
    
connect to windows via remote desktop connection 

windows serach - mstsc 
    hostname: your ubuntu ip from note pad
    user name and password from note pad
    

Install missing patches on ubuntu
---

swich to root user on ubuntu server
---
sudo su
password; palmeto

Get latest repo details
---
apt update

install missing patches
---
apt upgrade -y

Pre Assessment Link:
---
https://forms.cloud.microsoft/r/5H91ctkLU2

Create a github account ir signup
---
https://github.com/

start 30 day trail of enterprise
--

git hub users profile icon -- Enterprise -- start 30 day trial 

select "Enterprise Managed Users"

complete the registration.

swich to personal account
---
https://github.com/ 

login with persinal account

Create a repo
---

github icon -- new

Repository name: javaapp
visiblity: public
ADD readme: no
add .gitignore: No .gitignore
Add License: no License

Create repository

connect to ubuntu and create a key pair
----
sudo su

ssh-keygen

Enter file in which to save the key (/root/.ssh/id_rsa):  press ENTER key

Enter passphrase (empty for no passphrase): press ENTER key
Enter same passphrase again: press ENTER key

get the content of the public key
---
cat /root/.ssh/id_rsa.pub

add the ssh key to the user
---

user profile -- settings -- SSH and GPG keys 
    New ssh key
        Title: ubuntu
        key type: authendication
        key: paste the out put of cat command
    Add SSH key  

Create files in ubuntu
---

swich to root user home directory
---
cd

create a directory and switch to the dir
---
mkdir github-actions-training
cd github-actions-training

Create initial R

Install git
---
apt install git -y

initialize the repo
---
git init

install tree command
---
apt install tree

see the directctory structure of the .git folder
---
tree .git

Create initial README
---
echo "# GitHub Actions Training Lab Repository" > README.md

setup git config
---
git config --global user.email "sathishbabudevops@gmail.com"
git config --global user.name "sathishbabu"

add the file to staging
---
git add .

commit the changes
---
git commit -m "initial commit"

get the remote add command from git
---
git hub -- your repo -- select ssh -- copy remode add commns

sample command
---
git remote add origin git@github.com:{your github id}/{your repo name}.git

change the branch to main
---
git branch -M main

push it
--
git push -u origin main

yes

Use only if issue to push 
---
git remote -v
git remote rm origin

Add ubuntu runner
---

Go to your repository
Click Settings → Actions → Runners
Click “New self-hosted runner”

Runner Image : Linux

connect to ubuntu
---

switch to root user home directory
---
cd

create a directory for runner
---
mkdir actions-runner && cd actions-runner

install curl
---
apt install curl -y

Download the latest runner package
---
curl -o actions-runner-linux-x64-2.333.0.tar.gz -L https://github.com/actions/runner/releases/download/v2.333.0/actions-runner-linux-x64-2.333.0.tar.gz

Extract the installer
---
tar xzf ./actions-runner-linux-x64-2.333.0.tar.gz


Create a Non-Root User
---
adduser github-runner

add the user to sudo group
---
usermod -aG sudo github-runner

swich to the user
---
su - github-runner

create a directory for runner
---
mkdir actions-runner && cd actions-runner

Download the latest runner package
---
curl -o actions-runner-linux-x64-2.333.0.tar.gz -L https://github.com/actions/runner/releases/download/v2.333.0/actions-runner-linux-x64-2.333.0.tar.gz

Extract the installer
---
tar xzf ./actions-runner-linux-x64-2.333.0.tar.gz

Create the runner and start the configuration experience
---
./config.sh --url https://github.com/{your github id}/{your repo} --token {yur token}

Enter the name of the runner group to add this runner to: [press Enter for Default] Press ENTER

name of the runner: ubunturunner

Enter any additional labels (ex. label-1,label-2): [press Enter to skip] ubunturunner

Enter name of work folder: [press Enter for _work] Press ENTER

Run the runner
---
./run.sh

CTRL + c 

Run the agent as service
--
sudo ./svc.sh install
sudo ./svc.sh start


Day 2
===

Add windows agent
---

connect to windows VM via RDP

open powershell
---

windows search -- powershell

switch to c:\ directory
--
cd c:\

Create a folder under the drive root
---
mkdir actions-runner; cd actions-runner

Download the latest runner package
---
Invoke-WebRequest -Uri https://github.com/actions/runner/releases/download/v2.333.0/actions-runner-win-x64-2.333.0.zip -OutFile actions-runner-win-x64-2.333.0.

Extract the installer
----
Add-Type -AssemblyName System.IO.Compression.FileSystem ; [System.IO.Compression.ZipFile]::ExtractToDirectory("$PWD/actions-runner-win-x64-2.333.0.zip", "$PWD")

configure
---
./config.cmd --url https://github.com/{your github id}/{your repo name} --token {your token}

Enter the name of the runner group to add this runner to: [press Enter for Default -- Press ENTER

Enter the name of runner: [press Enter for WIN-5LQ9955JE3K] -- windowsrunner

This runner will have the following labels: 'self-hosted', 'Windows', 'X64'
Enter any additional labels (ex. label-1,label-2): [press Enter to skip] -- windowsrunner

Enter name of work folder: [press Enter for _work] -- Press ENTER

√ Settings Saved.

Would you like to run the runner as service? (Y/N) [press Enter for N] Y

install vscode
--

in the base windows machine downaload
--
https://code.visualstudio.com/download

downlaod windows

and install abd select your theam.

connect to repii
---
click "connect to"

remote repo

select "open repo github"

allow

once auth is done open your repo

create workflow folder
---
Create folder
.github

inside this create the folder
workflows

create file under workflow
firstworkflow.yml

actions list
---
https://github.com/marketplace?type=actions

name: Explore GitHub Components

on:
  push:
    branches: [main]
  workflow_dispatch:

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest
    steps:
      - name: checkout code
        uses: actions/checkout@v4

      - name: Display runner info
        run: |
          echo "Runner os: $RUNNER_OS"
          echo "Runner Atch: $RUNNER_ARCH"
          echo "workspace: $GITHUB_WORKSPACE"
          echo "Repository: $GITHUB_REPOSITORY"
          echo "Event: $GITHUB_EVENT_NAME"
          echo "SHA: $GITHUB_SHA"
          
save the file commit and push

check the action execution
---
repo -- action

update the code to print versions of the tolls avaliable
---
name: Explore GitHub Components

on:
  push:
    branches: [main]
  workflow_dispatch:

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest
    steps:
      - name: checkout code
        uses: actions/checkout@v6

      - name: Display runner info
        run: |
          echo "Runner os: $RUNNER_OS"
          echo "Runner Atch: $RUNNER_ARCH"
          echo "workspace: $GITHUB_WORKSPACE"
          echo "Repository: $GITHUB_REPOSITORY"
          echo "Event: $GITHUB_EVENT_NAME"
          echo "SHA: $GITHUB_SHA"

      - name: List installed tools
        run: |
          echo "=== Java ==="
          java -version 2>&1 || echo 'Not installed'
          echo "=== Node ==="
          node --version || echo 'Not installed'
          echo "=== Python ==="
          python3 --version || echo 'Not installed'
          echo "=== Docker ==="
          docker --version || echo 'Not installed'

save the file commit and push

check the action execution
---
repo -- action

add a test job to the workflow
---
name: Explore GitHub Components

on:
  push:
    branches: [main]
  workflow_dispatch:

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest
    steps:
      - name: checkout code
        uses: actions/checkout@v6

      - name: Display runner info
        run: |
          echo "Runner os: $RUNNER_OS"
          echo "Runner Atch: $RUNNER_ARCH"
          echo "workspace: $GITHUB_WORKSPACE"
          echo "Repository: $GITHUB_REPOSITORY"
          echo "Event: $GITHUB_EVENT_NAME"
          echo "SHA: $GITHUB_SHA"

      - name: List installed tools
        run: |
          echo "=== Java ==="
          java -version 2>&1 || echo 'Not installed'
          echo "=== Node ==="
          node --version || echo 'Not installed'
          echo "=== Python ==="
          python3 --version || echo 'Not installed'
          echo "=== Docker ==="
          docker --version || echo 'Not installed'

  test:
    name: Test Job
    runs-on: ubuntu-latest
    needs: build
    steps:
      - name: Run Mock test
        run: |
          echo "Running unit test"
          echo "all tests passes"
          




add always run job
---
name: Explore GitHub Components

on:
  push:
    branches: [main]
  workflow_dispatch:

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest
    steps:
      - name: checkout code
        uses: actions/checkout@v6

      - name: Display runner info
        run: |
          echo "Runner os: $RUNNER_OS"
          echo "Runner Atch: $RUNNER_ARCH"
          echo "workspace: $GITHUB_WORKSPACE"
          echo "Repository: $GITHUB_REPOSITORY"
          echo "Event: $GITHUB_EVENT_NAME"
          echo "SHA: $GITHUB_SHA"

      - name: List installed tools
        run: |
          echo "=== Java ==="
          java -version 2>&1 || echo 'Not installed'
          echo "=== Node ==="
          node --version || echo 'Not installed'
          echo "=== Python ==="
          python3 --version || echo 'Not installed'
          echo "=== Docker ==="
          docker --version || echo 'Not installed'

  test:
    name: Test Job
    runs-on: ubuntu-latest
    needs: build
    steps:
      - name: Run Mock test
        run: |
          echo "Running unit test"
          echo "all tests passes"

  notify:
    name: Notification Job
    runs-on: ubuntu-latest
    needs: [build, test]
    if: always()
    steps:
      - name: Send notification
        run: echo "Build and test complete for $GITHUB_SHA"

save the file commit and push

check the action execution
---
repo -- action

Environment variables
---
create new workflow file envvars.yml

name: Env Variables Demo

on: workflow_dispatch

env:
  GLOBAL_ENV: "global-value"

jobs:
  demo:
    runs-on: ubuntu-latest

    env:
      JOB_ENV: "job-value"

    steps:
      - name: Print all env vars
        run: |
          echo "Global: $GLOBAL_ENV"
          echo "Job: $JOB_ENV"

      - name: Step-level env
        env:
          STEP_ENV: "step-value"
        run: |
          echo "Step: $STEP_ENV"
          echo "Global: $GLOBAL_ENV"
          echo "Job: $JOB_ENV"
          
save the file commit and push

check the action execution
---
repo -- action

Env Variables Demo

run work flow

Create 3 environment
---
Repo → Settings → Environments -- new environments

development
test
production

Open production and add 2 variables
---
API_URL = https://prod.api.com
APP_MODE = production

remove automatic trigger on firstworkflow.yml
---
name: Explore GitHub Components

on:
  workflow_dispatch

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest
    steps:
      - name: checkout code
        uses: actions/checkout@v6

      - name: Display runner info
        run: |
          echo "Runner os: $RUNNER_OS"
          echo "Runner Atch: $RUNNER_ARCH"
          echo "workspace: $GITHUB_WORKSPACE"
          echo "Repository: $GITHUB_REPOSITORY"
          echo "Event: $GITHUB_EVENT_NAME"
          echo "SHA: $GITHUB_SHA"

      - name: List installed tools
        run: |
          echo "=== Java ==="
          java -version 2>&1 || echo 'Not installed'
          echo "=== Node ==="
          node --version || echo 'Not installed'
          echo "=== Python ==="
          python3 --version || echo 'Not installed'
          echo "=== Docker ==="
          docker --version || echo 'Not installed'

  test:
    name: Test Job
    runs-on: ubuntu-latest
    needs: build
    steps:
      - name: Run Mock test
        run: |
          echo "Running unit test"
          echo "all tests passes"

  notify:
    name: Notification Job
    runs-on: ubuntu-latest
    needs: [build, test]
    if: always()
    steps:
      - name: Send notification
        run: echo "Build and test complete for $GITHUB_SHA"
        
save the file

Modify envvars.yml to use the variables from environment
----
name: Env Variables Demo

on: workflow_dispatch

env:
  GLOBAL_ENV: "global-value"

jobs:
  deploy:
    runs-on: ubuntu-latest

    environment: production  

    steps:
      - name: Use environment variables
        env:
          API_URL: ${{ vars.API_URL }}
          APP_MODE: ${{ vars.APP_MODE }}
        run: |
          echo "API URL: $API_URL"
          echo "App Mode: $APP_MODE"
          
save the file

Commot and push

run work flow

dynamic runners for refernce
---
name: Dynamic Runner

on: workflow_dispatch

env:
  APP_TYPE: java   # change to 'dotnet'

jobs:
  build:
    runs-on: ${{ env.APP_TYPE == 'java' && 'ubuntu-latest' || 'windows-latest' }}

    steps:
      - name: Show runner
        run: echo "Running on $RUNNER_OS"
        
        
secrets in workflow
---
Open production and add 1 secret
---
DB_PASSWORD some value

modify the workflow yaml
---

name: Env Variables Demo

on: workflow_dispatch

env:
  GLOBAL_ENV: "global-value"

jobs:
  deploy:
    runs-on: ubuntu-latest

    environment: production  

    steps:
      - name: Use environment variables
        env:
          API_URL: ${{ vars.API_URL }}
          DB_PASS: ${{ secrets.DB_PASSWORD }}
        run: |
          echo "Deploying to $API_URL"
          echo "DB password length: ${#DB_PASS}"
          echo "DB password is ${DB_PASS}"
          
save the file

Commot and push

run work flow

Try to print secret
---

name: Env Variables Demo

on: workflow_dispatch

env:
  GLOBAL_ENV: "global-value"

jobs:
  deploy:
    runs-on: ubuntu-latest

    environment: production  

    steps:
      - name: Use environment variables
        env:
          API_URL: ${{ vars.API_URL }}
          DB_PASS: ${{ secrets.DB_PASSWORD }}
        run: |
          echo "Deploying to $API_URL"
          echo "DB password length: ${#DB_PASS}"
          echo "DB password is ${DB_PASS}"

      - name: Write secret to file
        run: |
          echo "$DB_PASS" > secret.txt
        env:
          DB_PASS: ${{ secrets.DB_PASSWORD }}

      - name: Print file
        run: cat secret.txt
        
save the file

Commit and push

run work flow

dynamic runner
---
name: Smart Build Pipeline

on:
  workflow_dispatch:

jobs:
  # 🔍 Detect application type
  detect:
    runs-on: ubuntu-latest
    outputs:
      app: ${{ steps.detect.outputs.app }}

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Detect application type
        id: detect
        run: |
          if [ -f "pom.xml" ] || [ -f "build.gradle" ]; then
            echo "Detected Java project"
            echo "app=java" >> $GITHUB_OUTPUT
          elif ls *.csproj 1> /dev/null 2>&1; then
            echo "Detected .NET project"
            echo "app=dotnet" >> $GITHUB_OUTPUT
          else
            echo "Unknown project type"
            echo "app=unknown" >> $GITHUB_OUTPUT
          fi

  # 🏗️ Build job (dynamic runner selection)
  build:
    needs: detect
    runs-on: ${{ needs.detect.outputs.app == 'java' && 'ubuntu-latest' || 'windows-latest' }}

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Print detected app
        run: echo "App is ${{ needs.detect.outputs.app }}"

      # ☕ Java Build
      - name: Set up JDK
        if: needs.detect.outputs.app == 'java'
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: 17

      - name: Build Java (Maven)
        if: needs.detect.outputs.app == 'java' && hashFiles('pom.xml') != ''
        run: mvn clean install -B

      - name: Build Java (Gradle)
        if: needs.detect.outputs.app == 'java' && hashFiles('build.gradle') != ''
        run: ./gradlew build

      # 🟣 .NET Build
      - name: Setup .NET
        if: needs.detect.outputs.app == 'dotnet'
        uses: actions/setup-dotnet@v4
        with:
          dotnet-version: '8.0.x'

      - name: Restore dependencies
        if: needs.detect.outputs.app == 'dotnet'
        run: dotnet restore

      - name: Build .NET
        if: needs.detect.outputs.app == 'dotnet'
        run: dotnet build --configuration Release

      # ❌ Fail if unknown
      - name: Fail if unknown app
        if: needs.detect.outputs.app == 'unknown'
        run: |
          echo "Unsupported project type"
          exit 1

save the file

Commit and push

run work flow


Matrix staergy in pipeline
--
matrix.yml

name: Matrix Demo

on: workflow_dispatch

jobs:
  test:
    strategy:
      matrix:
        os: [ubuntu-latest, windows-latest]
        node: [18, 20]

    runs-on: ${{ matrix.os }}

    steps:
      - name: Print config
        run: |
          echo "OS: ${{ matrix.os }}"
          echo "Node: ${{ matrix.node }}"
          
save the file

Commit and push

run work flow


condition in workflow with condition.yml
---

name: Condition Demo

on: workflow_dispatch

jobs:
  build:
    runs-on: ubuntu-latest
    if: github.ref == 'refs/heads/main'

    steps:
      - run: echo "Running on main branch"

save the file

Commit and push

run work flow with main branch


Create a dev branch
--

repo -- brach -- new branch "dev"

run work flow with dev branch

step level condition
---
name: Condition Demo

on: workflow_dispatch

jobs:
  build:
    runs-on: ubuntu-latest
    if: github.ref == 'refs/heads/main'

    steps:
      - name: Step 1
        run: echo "Hello"

      - name: step 2
        if: failure()
        run: echo "Runs only if Step 1 failled"


save the file

Commit and push

run work flow

condition based on user input
---
name: Condition Demo

on:
  workflow_dispatch:
    inputs:
      environment:
        required: true
        default: dev

jobs:
  deploy:
    runs-on: ubuntu-latest
    if: github.event.inputs.environment == 'prod'

    steps:
      - run: echo "Deploying to Production"
      
save the file

Commit and push

run work flow with value for environment as dev (default)

run work flow with value for environment as prod (default)

step condition on user input
---
name: Condition Demo

on:
  workflow_dispatch:
    inputs:
      environment:
        required: true
        default: dev

jobs:
  deploy:
    runs-on: ubuntu-latest

    steps:
      - name: Always Run Step
        run: echo "This step always runs"

      - name: Deploy to Production
        if: github.event.inputs.environment == 'prod'
        run: echo "Deploying to Production"
        
save the file

Commit and push

run work flow with value for environment as dev (default)

run work flow with value for environment as prod (default)

input types input.yml
---
name: Advanced Input Demo

on:
  workflow_dispatch:
    inputs:
      environment:
        type: choice
        options: [dev, stage, prod]
      run_tests:
        type: boolean
        default: true
      retry_count:
        type: number
        default: 1

jobs:
  deploy:
    runs-on: ubuntu-latest

    steps:
      - name: Always Run
        run: echo "Pipeline started"

      - name: Run Tests
        if: github.event.inputs.run_tests == 'true'
        run: echo "Executing tests"

      - name: Deploy to Dev
        if: github.event.inputs.environment == 'dev'
        run: echo "Deploying to Dev"

      - name: Deploy to Prod
        if: github.event.inputs.environment == 'prod'
        run: echo "Deploying to Production"

      - name: Retry Logic
        if: github.event.inputs.retry_count > 1
        run: echo "Retries enabled"
        
save the file

Commit and push

run work flow with default value

multiple condition allcondition.yaml
---
name: All Conditions Demo

on:
  push:
    branches: [main, dev]
  workflow_dispatch:
    inputs:
      environment:
        description: "Target environment"
        required: true
        default: dev

env:
  ENVIRONMENT: prod

jobs:

  # 🔹 1. Job runs only on main branch + push
  build:
    runs-on: ubuntu-latest
    if: github.ref == 'refs/heads/main' && github.event_name == 'push'

    steps:
      - name: Print context
        run: |
          echo "Branch: ${{ github.ref }}"
          echo "Event: ${{ github.event_name }}"

      - name: Step runs only if previous succeeds
        if: success()
        run: echo "Previous step succeeded"

      - name: Run only if commit message contains 'deploy'
        if: contains(github.event.head_commit.message, 'deploy')
        run: echo "Deploy keyword detected"

      - name: Skip bot user
        if: github.actor != 'dependabot[bot]'
        run: echo "Not triggered by bot"


  # 🔹 2. Job using workflow_dispatch input
  deploy-input:
    runs-on: ubuntu-latest
    if: github.event_name == 'workflow_dispatch' && github.event.inputs.environment == 'prod'

    steps:
      - run: echo "Manual deployment to PROD"


  # 🔹 3. Env condition (moved to step level)
  env-check:
    runs-on: ubuntu-latest

    steps:
      - name: Run only if env is prod
        if: env.ENVIRONMENT == 'prod'
        run: echo "Environment is PROD"


  # 🔹 4. Matrix job with condition
  matrix-test:
    strategy:
      matrix:
        os: [ubuntu-latest, windows-latest]
        node: [18, 20]

    runs-on: ${{ matrix.os }}

    steps:
      - name: Print matrix config
        run: |
          echo "OS: ${{ matrix.os }}"
          echo "Node: ${{ matrix.node }}"

      - name: Run only on Ubuntu
        if: matrix.os == 'ubuntu-latest'
        run: echo "Running Ubuntu-specific step"


  # 🔹 5. Secrets check (fixed using env mapping)
  secrets-check:
    runs-on: ubuntu-latest

    steps:
      - name: Check secret safely
        env:
          MY_SECRET: ${{ secrets.MY_SECRET }}
        if: env.MY_SECRET != ''
        run: echo "Secret is configured"


  # 🔹 6. Failure handling example
  failure-demo:
    runs-on: ubuntu-latest

    steps:
      - name: Force failure
        run: exit 1

      - name: Runs only on failure
        if: failure()
        run: echo "Previous step failed"

      - name: Always runs
        if: always()
        run: echo "Cleanup step"


  # 🔹 7. Combined logical conditions
  combined-condition:
    runs-on: ubuntu-latest
    if: (github.ref == 'refs/heads/main' || github.ref == 'refs/heads/dev') && github.event_name == 'push'

    steps:
      - run: echo "Running on main OR dev branch"


  # 🔹 8. Cancel condition example
  cancel-demo:
    runs-on: ubuntu-latest

    steps:
      - name: Dummy step
        run: echo "Simulating job"

      - name: Runs if cancelled
        if: cancelled()
        run: echo "Workflow was cancelled"
        
save the file

Commit with "deploy" in the commit message and push

view the action execution

run work flow with default value

scheduled and parallel scheduled .yaml
---
name: scheduled Pipeline

on:
  schedule:
    - cron: "*/5 * * * *"

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - run: echo "Running tests"

  lint:
    runs-on: ubuntu-latest
    steps:
      - run: echo "Linting code"

  report:
    runs-on: ubuntu-latest
    needs: [test, lint]
    steps:
      - run: echo "Generating report"
      
save the file

remove on push in allcondition.ymal

Commit  and push

view the action execution

chnange the schedule to run at 9:00 am
---
name: scheduled Pipeline

on:
  schedule:
    - cron: "0 9 * * *"

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - run: echo "Running tests"

  lint:
    runs-on: ubuntu-latest
    steps:
      - run: echo "Linting code"

  report:
    runs-on: ubuntu-latest
    needs: [test, lint]
    steps:
      - run: echo "Generating report"
      
      
Day 3
===

java app 
---

create pom.xml for maven
---


<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>java-demo-app</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Surefire plugin for tests -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
            </plugin>
        </plugins>
    </build>

</project>

Create java application
---

src/main/java/com/example/App.java

package com.example;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Sum: " + app.add(5, 3));
    }
}

Create test file
---

src/test/java/com/example/AppTest.java


package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testAdd() {
        App app = new App();
        assertEquals(8, app.add(5, 3));
    }
}

Craete  javaapp.yml
---

name: Java Apllication Build

on:
  workflow_dispatch:

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest

    steps:
      - name: checkout code
        uses: actions/checkout@v6

      - name: set up jdk 17
        uses: actions/setup-java@v5
        with:
          distribution: 'temurin' 
          java-version: '17'

      - name: Build with Maven
        run: mvn clean package

      - name: run tests
        run: mvn test
        
save -- commit and push 

Run the workflow

action documentation
---
https://github.com/marketplace?query=artifact&type=actions

update workflow with cache and artifact
---

name: Java Apllication Build

on:
  workflow_dispatch:

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest

    steps:
      - name: checkout code
        uses: actions/checkout@v6

      - name: set up jdk 17
        uses: actions/setup-java@v5
        with:
          distribution: 'temurin' 
          java-version: '17'
          cache: 'maven'

      - name: Build with Maven
        run: mvn clean package

      - name: run tests
        run: mvn test

      - name: upload Artifacr
        uses: actions/upload-artifact@v4
        with:
          name: java-demo-artifact
          path: target/*.jar 


save -- commit and push 

Run the workflow

publish the test result
---
name: Java Apllication Build

on:
  workflow_dispatch:

jobs:
  build:
    name: Build job
    runs-on: ubuntu-latest

    steps:
      - name: checkout code
        uses: actions/checkout@v6

      - name: set up jdk 17
        uses: actions/setup-java@v5
        with:
          distribution: 'temurin' 
          java-version: '17'
          cache: 'maven'

      - name: Build with Maven
        run: mvn clean package

      - name: run tests
        run: mvn test

      - name: Publish Test Report
        uses: dorny/test-reporter@v3
        if: always()   
        with:
          name: JUnit Tests
          path: target/surefire-reports/*.xml
          reporter: java-junit

      - name: upload Artifacr
        uses: actions/upload-artifact@v4
        with:
          name: java-demo-artifact
          path: target/*.jar 
          
save -- commit and push 

Run the workflow
          
enable workflow permission repo-level workflow permission
---

Go to your repo 
Click Settings (repo settings, not account settings)
Left sidebar → Actions → General
Scroll down to "Workflow permissions"
Select "Read and write permissions"
Click Save


Add a docker file in the repo root Dockerfile
---

# --- Stage 1: Build ---
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests -B

# --- Stage 2: Runtime ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/java-demo-app-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

Add a workflow file docker-build.yml
---
name: Docker Build and Push to GHCR

on:
  workflow_dispatch:
env:
  REGISTRY: ghcr.io
  IMAGE_NAME: ${{ github.repository }}   

jobs:
  build:
    name: Build Java App
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Build and Test
        run: mvn clean package

      - name: Publish Test Report
        uses: dorny/test-reporter@v3
        if: always()
        with:
          name: JUnit Tests
          path: target/surefire-reports/*.xml
          reporter: java-junit

  docker:
    name: Docker Build & Push to GHCR
    runs-on: ubuntu-latest
    needs: build
    permissions:
      contents: read
      packages: write

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v3

      - name: Login to GitHub Container Registry
        uses: docker/login-action@v3
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUB_TOKEN }}

      - name: Extract metadata (tags, labels)
        id: meta
        uses: docker/metadata-action@v5
        with:
          images: ghcr.io/${{ github.repository }}
          tags: |
            type=sha,prefix=
            type=raw,value=latest,enable={{is_default_branch}}

      - name: Build and Push Docker Image
        uses: docker/build-push-action@v6
        with:
          context: .
          push: true
          tags: ${{ steps.meta.outputs.tags }}
          labels: ${{ steps.meta.outputs.labels }}
          cache-from: type=gha
          cache-to: type=gha,mode=max
          
save -- commit and push 

Run the workflow

See the omages
---
Go to your repo → look at the right sidebar → you'll see a "Packages" section listed there. Click on the package name (javaapp) to see all the image tags, versions, and pull commands.

Add the git leaks security.yml
---

name: Secret Scan - Gitleaks

on:
  workflow_dispatch:

jobs:
  gitleaks:
    name: Gitleaks Secret Scan
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 0    # full history so gitleaks can scan all commits

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
        continue-on-error: true   # don't fail yet, we handle it in quality gate

      - name: Upload Gitleaks SARIF Report
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
        continue-on-error: true

      - name: Upload Gitleaks Report as Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Fail on Secrets Found
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED"
          echo "  Gitleaks found hardcoded secrets!"
          echo "  Check the Security tab or download the"
          echo "  gitleaks-report artifact for details."
          echo "=========================================="
          exit 1
          
save -- commit and push 

Run the workflow

in githun ui -- create the file test-secret.txt and commit it
----

# Slack Webhook
SLACK_WEBHOOK=https://hooks.slack.com/services/T01234567/B01234567/xyzABCDEFghijklmnopqrstu

# GitHub PAT
GITHUB_PAT=ghp_1234567890abcdefghijklmnopqrstuABCDE

# AWS Key (realistic pattern)
AWS_ACCESS_KEY_ID=AKIAQWERTYUIOP12AB34
AWS_SECRET_ACCESS_KEY=abcDEF123ghiJKL456mnoQRS789tuvWXY012zABx

# Private Key
-----BEGIN RSA PRIVATE KEY-----
MIIEowIBAAKCAQEA0Z3VS5JJcds3xfn/ygWyF8PbnGy0AHB7MhgHcTz6sE2I2yPB
aBBDgMhTkGQkPqvFBXl5mYEoIpGPKHgrFMgij4MGQx5+mLq9ADJpMJj+haFCqArM
-----END RSA PRIVATE KEY-----

default git ;;leaks regex
--
https://github.com/gitleaks/gitleaks/blob/master/config/gitleaks.toml

with custom config
---
Create a .gitleaks.toml 
---

# Extend the default gitleaks rules
title = "Custom Gitleaks Config"

# Rule 1: Catch password assignments in config files
[[rules]]
id = "generic-password"
description = "Hardcoded password detected"
regex = '''(?i)(password|passwd|pwd)\s*[=:]\s*['"]?[\w@#$%^&*!]{4,}['"]?'''
keywords = ["password", "passwd", "pwd"]
tags = ["password", "hardcoded"]

# Rule 2: Catch DB credentials
[[rules]]
id = "db-credentials"
description = "Database credential detected"
regex = '''(?i)(db_password|db_pass|db_secret|database_password)\s*[=:]\s*['"]?[\w@#$%^&*!]{3,}['"]?'''
keywords = ["db_password", "db_pass", "db_secret", "database_password"]
tags = ["database", "credential"]

# Rule 3: Catch connection strings with passwords
[[rules]]
id = "connection-string"
description = "Connection string with embedded password"
regex = '''(?i)(jdbc|mysql|postgresql|mongodb|redis):\/\/\w+:[^@\s]+@'''
keywords = ["jdbc", "mysql", "postgresql", "mongodb", "redis"]
tags = ["connection-string"]

# Rule 4: Catch generic secrets/tokens
[[rules]]
id = "generic-secret"
description = "Hardcoded secret or token detected"
regex = '''(?i)(secret|token|api_key|apikey|access_key)\s*[=:]\s*['"]?[\w\-/+]{8,}['"]?'''
keywords = ["secret", "token", "api_key", "apikey", "access_key"]
tags = ["secret", "token"]


modify test-secret.txt
----

# Database credentials
DB_HOST=localhost
DB_USER=admin
DB_password='name123'

# App secrets
API_KEY=mySuper$ecretKey2024abc
APP_SECRET=xK9mP2vL8nQ4wR7jB3yT

# Connection string
JDBC_URL=jdbc:mysql://admin:password123@db.example.com:3306/mydb

# Slack webhook (default rule catches this)
SLACK_WEBHOOK=https://hooks.slack.com/services/T01234567/B01234567/xyzABCDEFghijklmnopqrstu

updated workflow with custom toml file
---

name: Secret Scan - Gitleaks

on:
  workflow_dispatch:

jobs:
  gitleaks:
    name: Gitleaks Secret Scan
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 0    # full history so gitleaks can scan all commits

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
        continue-on-error: true   # don't fail yet, we handle it in quality gate

      - name: Upload Gitleaks SARIF Report
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
        continue-on-error: true

      - name: Upload Gitleaks Report as Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Fail on Secrets Found
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED"
          echo "  Gitleaks found hardcoded secrets!"
          echo "  Check the Security tab or download the"
          echo "  gitleaks-report artifact for details."
          echo "=========================================="
          exit 1
          
save -- commit and push 

Run the workflow

securoty work flow with sca
---

name: Security Scans - Secrets & SCA

on:
  workflow_dispatch:

jobs:

  # ---- Job 1: Secret Scan ----
  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
        continue-on-error: true

      - name: Upload Gitleaks SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: gitleaks
        continue-on-error: true

      - name: Upload Gitleaks Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Secrets
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "=========================================="
          exit 1

  # ---- Job 2: SCA - Dependency Scan ----
  sca:
    name: SCA - Dependency Check
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Cache OWASP NVD Data
        uses: actions/cache@v4
        with:
          path: ~/.m2/repository/org/owasp
          key: owasp-nvd-${{ github.run_id }}
          restore-keys: owasp-nvd-

      - name: Run OWASP Dependency-Check
        id: depcheck
        run: |
          mvn org.owasp:dependency-check-maven:check \
            -DfailBuildOnCVSS=7 \
            -Dformats=HTML,JSON,SARIF \
            -DprettyPrint=true \
            -DsuppressionsFile=owasp-suppressions.xml \
            -B
        continue-on-error: true

      - name: Upload OWASP SARIF to Security Tab
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: target/dependency-check-report.sarif
          category: owasp-dependency-check
        continue-on-error: true

      - name: Upload OWASP HTML Report
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: owasp-dependency-check-report
          path: |
            target/dependency-check-report.html
            target/dependency-check-report.json
          retention-days: 30

      - name: Quality Gate - SCA
        if: steps.depcheck.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CVEs FOUND"
          echo "  CVSS score >= 7 (HIGH/CRITICAL)"
          echo "  Download the OWASP report artifact"
          echo "  for full details."
          echo "=========================================="
          exit 1

  # ---- Job 3: Summary Gate ----
  security-gate:
    name: Security Quality Gate
    runs-on: ubuntu-latest
    needs: [gitleaks, sca]
    if: always()
    steps:
      - name: Check all scan results
        run: |
          echo "=========================================="
          echo "  SECURITY SCAN SUMMARY"
          echo "=========================================="
          echo "  Gitleaks  : ${{ needs.gitleaks.result }}"
          echo "  SCA/OWASP : ${{ needs.sca.result }}"
          echo "=========================================="

          if [[ "${{ needs.gitleaks.result }}" != "success" || "${{ needs.sca.result }}" != "success" ]]; then
            echo ""
            echo "  ONE OR MORE SCANS FAILED"
            echo "  Pipeline blocked. Fix issues and re-run."
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED"
          echo "=========================================="
          
Create a secret
---

repo settings

name:NVD_API_KEY

key: 26fbb928-c9ed-451d-8f51-7a0bf88301e6

updated workflow
---
name: Security Scans - Secrets & SCA

on:
  workflow_dispatch:

jobs:

  # ---- Job 1: Secret Scan ----
  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
        continue-on-error: true

      - name: Upload Gitleaks SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: gitleaks
        continue-on-error: true

      - name: Upload Gitleaks Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Secrets
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "=========================================="
          exit 1

  # ---- Job 2: SCA - Dependency Scan ----
  sca:
    name: SCA - Dependency Check
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Cache OWASP NVD Data
        uses: actions/cache@v4
        with:
          path: ~/.m2/repository/org/owasp
          key: owasp-nvd-${{ github.run_id }}
          restore-keys: owasp-nvd-

      - name: Run OWASP Dependency-Check
        id: depcheck
        run: |
          mvn org.owasp:dependency-check-maven:check \
            -DfailBuildOnCVSS=7 \
            -Dformats=HTML,JSON,SARIF \
            -DprettyPrint=true \
            -DsuppressionsFile=owasp-suppressions.xml \
            -DnvdApiKey=${{ secrets.NVD_API_KEY }} \
            -B
        continue-on-error: true

      - name: Upload OWASP SARIF to Security Tab
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: target/dependency-check-report.sarif
          category: owasp-dependency-check
        continue-on-error: true

      - name: Upload OWASP HTML Report
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: owasp-dependency-check-report
          path: |
            target/dependency-check-report.html
            target/dependency-check-report.json
          retention-days: 30

      - name: Quality Gate - SCA
        if: steps.depcheck.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CVEs FOUND"
          echo "  CVSS score >= 7 (HIGH/CRITICAL)"
          echo "  Download the OWASP report artifact"
          echo "  for full details."
          echo "=========================================="
          exit 1

  # ---- Job 3: Summary Gate ----
  security-gate:
    name: Security Quality Gate
    runs-on: ubuntu-latest
    needs: [gitleaks, sca]
    if: always()
    steps:
      - name: Check all scan results
        run: |
          echo "=========================================="
          echo "  SECURITY SCAN SUMMARY"
          echo "=========================================="
          echo "  Gitleaks  : ${{ needs.gitleaks.result }}"
          echo "  SCA/OWASP : ${{ needs.sca.result }}"
          echo "=========================================="

          if [[ "${{ needs.gitleaks.result }}" != "success" || "${{ needs.sca.result }}" != "success" ]]; then
            echo ""
            echo "  ONE OR MORE SCANS FAILED"
            echo "  Pipeline blocked. Fix issues and re-run."
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED"
          echo "=========================================="

replace owasp dependency check to trivy
---
name: Security Scans - Secrets & SCA

on:
  workflow_dispatch:

jobs:

  # ---- Job 1: Secret Scan ----
  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
        continue-on-error: true

      - name: Upload Gitleaks SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: gitleaks
        continue-on-error: true

      - name: Upload Gitleaks Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Secrets
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "=========================================="
          exit 1

  # ---- Job 2: SCA - Trivy Dependency Scan ----
  sca:
    name: SCA - Trivy Dependency Scan
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Run Trivy SCA Scan
        id: trivy
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'table'
          severity: 'CRITICAL,HIGH'
          exit-code: '1'
        continue-on-error: true

      - name: Run Trivy SARIF Report
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-results.sarif'
          severity: 'CRITICAL,HIGH'

      - name: Upload Trivy SARIF to Security Tab
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-results.sarif
          category: trivy-sca
        continue-on-error: true

      - name: Upload Trivy Report Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-sca-report
          path: trivy-results.sarif
          retention-days: 30

      - name: Quality Gate - SCA
        if: steps.trivy.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CVEs FOUND"
          echo "  HIGH/CRITICAL vulnerabilities detected"
          echo "  Check Security tab or download the"
          echo "  trivy-sca-report artifact for details."
          echo "=========================================="
          exit 1

  # ---- Job 3: Summary Gate ----
  security-gate:
    name: Security Quality Gate
    runs-on: ubuntu-latest
    needs: [gitleaks, sca]
    if: always()
    steps:
      - name: Check all scan results
        run: |
          echo "=========================================="
          echo "  SECURITY SCAN SUMMARY"
          echo "=========================================="
          echo "  Gitleaks  : ${{ needs.gitleaks.result }}"
          echo "  SCA/OWASP : ${{ needs.sca.result }}"
          echo "=========================================="

          if [[ "${{ needs.gitleaks.result }}" != "success" || "${{ needs.sca.result }}" != "success" ]]; then
            echo ""
            echo "  ONE OR MORE SCANS FAILED"
            echo "  Pipeline blocked. Fix issues and re-run."
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED"
          echo "=========================================="     


Add code ql for sast with quality gate
---

name: Security Scans - Secrets & SCA

on:
  workflow_dispatch:

jobs:

  # ---- Job 1: Secret Scan ----
  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
        continue-on-error: true

      - name: Upload Gitleaks SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: gitleaks
        continue-on-error: true

      - name: Upload Gitleaks Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Secrets
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "=========================================="
          exit 1

  # ---- Job 2: SCA - Trivy Dependency Scan ----
  sca:
    name: SCA - Trivy Dependency Scan
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Run Trivy SCA Scan
        id: trivy
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'table'
          severity: 'CRITICAL,HIGH'
          exit-code: '1'
        continue-on-error: true

      - name: Run Trivy SARIF Report
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-results.sarif'
          severity: 'CRITICAL,HIGH'

      - name: Upload Trivy SARIF to Security Tab
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-results.sarif
          category: trivy-sca
        continue-on-error: true

      - name: Upload Trivy Report Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-sca-report
          path: trivy-results.sarif
          retention-days: 30

      - name: Quality Gate - SCA
        if: steps.trivy.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CVEs FOUND"
          echo "  HIGH/CRITICAL vulnerabilities detected"
          echo "  Check Security tab or download the"
          echo "  trivy-sca-report artifact for details."
          echo "=========================================="
          exit 1

# ---- Job 3: SAST - CodeQL ----
  codeql:
    name: SAST - CodeQL Analysis
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Initialize CodeQL
        uses: github/codeql-action/init@v3
        with:
          languages: java-kotlin
          queries: security-and-quality

      - name: Build for CodeQL
        run: mvn clean package -DskipTests -B

      - name: Perform CodeQL Analysis
        id: codeql
        uses: github/codeql-action/analyze@v3
        with:
          category: codeql-java
          output: codeql-results

      - name: Check CodeQL Results
        id: codeql-check
        run: |
          # Count alerts from SARIF file
          ALERT_COUNT=$(jq '[.runs[].results[]] | length' codeql-results/*.sarif)
          echo "alert_count=$ALERT_COUNT" >> "$GITHUB_OUTPUT"
          echo "CodeQL found $ALERT_COUNT alert(s)"

      - name: Quality Gate - SAST
        if: steps.codeql-check.outputs.alert_count != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CODE ISSUES FOUND"
          echo "  CodeQL found ${{ steps.codeql-check.outputs.alert_count }} alert(s)"
          echo "  Check Security tab > Code scanning"
          echo "=========================================="
          exit 1

  # ---- Job 4: Summary Gate ----
  security-gate:
    name: Security Quality Gate
    runs-on: ubuntu-latest
    needs: [gitleaks, sca, codeql]
    if: always()
    steps:
      - name: Check all scan results
        run: |
          echo "=========================================="
          echo "  SECURITY SCAN SUMMARY"
          echo "=========================================="
          echo "  Gitleaks (Secrets) : ${{ needs.gitleaks.result }}"
          echo "  Trivy (SCA)       : ${{ needs.sca.result }}"
          echo "  CodeQL (SAST)     : ${{ needs.codeql.result }}"
          echo "=========================================="

          if [[ "${{ needs.gitleaks.result }}" != "success" || \
                "${{ needs.sca.result }}" != "success" || \
                "${{ needs.codeql.result }}" != "success" ]]; then
            echo ""
            echo "  ONE OR MORE SCANS FAILED"
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED"
          echo "=========================================="

add issue to the java app
---
To demo a CodeQL failure, replace App.java with this vulnerable version:


package com.example;

import java.sql.*;
import java.io.*;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    // VULN 1: SQL Injection
    public void getUser(Connection conn, String userInput) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'";
        stmt.executeQuery(query);
    }

    // VULN 2: Path Traversal
    public String readFile(String filename) throws IOException {
        File file = new File("/data/" + filename);
        return new String(java.nio.file.Files.readAllBytes(file.toPath()));
    }

    // VULN 3: Command Injection
    public void runCommand(String userInput) throws IOException {
        Runtime.getRuntime().exec("ping " + userInput);
    }

    // VULN 4: Hardcoded Password
    public Connection connectDB() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/mydb",
            "admin",
            "SuperSecret123!"
        );
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Sum: " + app.add(5, 3));
    }
}

Updated workflow yaml with fixed depth
---
name: DevSecOps Pipeline

on:
  workflow_dispatch:

env:
  REGISTRY: ghcr.io
  IMAGE_NAME: ${{ github.repository }}

jobs:

  # ========== STAGE 1: SECURITY SCANS (parallel) ==========

  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 1

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
          GITLEAKS_ARGUMENTS: --log-opts=-1
        continue-on-error: true

      - name: Upload Gitleaks SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: gitleaks
        continue-on-error: true

      - name: Upload Gitleaks Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Secrets
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "  Check Security tab or download"
          echo "  gitleaks-report artifact for details."
          echo "=========================================="
          exit 1

  sca:
    name: SCA - Trivy Dependency Scan
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Run Trivy SCA Scan
        id: trivy
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'table'
          severity: 'CRITICAL,HIGH'
          exit-code: '1'
        continue-on-error: true

      - name: Run Trivy SARIF Report
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-sca-results.sarif'
          severity: 'CRITICAL,HIGH'

      - name: Upload Trivy SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-sca-results.sarif
          category: trivy-sca
        continue-on-error: true

      - name: Upload Trivy Report Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-sca-report
          path: trivy-sca-results.sarif
          retention-days: 30

      - name: Quality Gate - SCA
        if: steps.trivy.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - DEPENDENCY CVEs"
          echo "  HIGH/CRITICAL vulnerabilities found"
          echo "  in project dependencies."
          echo "=========================================="
          exit 1

  codeql:
    name: SAST - CodeQL Analysis
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Initialize CodeQL
        uses: github/codeql-action/init@v3
        with:
          languages: java-kotlin
          queries: security-and-quality

      - name: Build for CodeQL
        run: mvn clean package -DskipTests -B

      - name: Perform CodeQL Analysis
        uses: github/codeql-action/analyze@v3
        with:
          category: codeql-java
          output: codeql-results

      - name: Count CodeQL Alerts
        id: codeql-check
        if: always()
        run: |
          ALERT_COUNT=$(jq '[.runs[].results[]] | length' codeql-results/*.sarif)
          echo "alert_count=$ALERT_COUNT" >> "$GITHUB_OUTPUT"
          echo "CodeQL found $ALERT_COUNT alert(s)"

      - name: Quality Gate - SAST
        if: steps.codeql-check.outputs.alert_count != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CODE ISSUES FOUND"
          echo "  CodeQL found ${{ steps.codeql-check.outputs.alert_count }} alert(s)"
          echo "  Check Security tab > Code scanning"
          echo "  for detailed findings."
          echo "=========================================="
          exit 1

  # ========== STAGE 2: SECURITY GATE ==========

  security-gate:
    name: Security Quality Gate
    runs-on: ubuntu-latest
    needs: [gitleaks, sca, codeql]
    if: always()
    steps:
      - name: Evaluate scan results
        run: |
          echo "=========================================="
          echo "  SECURITY SCAN SUMMARY"
          echo "=========================================="
          echo "  Gitleaks (Secrets) : ${{ needs.gitleaks.result }}"
          echo "  Trivy (SCA)       : ${{ needs.sca.result }}"
          echo "  CodeQL (SAST)     : ${{ needs.codeql.result }}"
          echo "=========================================="

          if [[ "${{ needs.gitleaks.result }}" != "success" || \
                "${{ needs.sca.result }}" != "success" || \
                "${{ needs.codeql.result }}" != "success" ]]; then
            echo ""
            echo "  PIPELINE BLOCKED - Fix issues first"
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED - Proceeding to build"
          echo "=========================================="

  # ========== STAGE 3: BUILD & TEST ==========

  build:
    name: Build & Test
    runs-on: ubuntu-latest
    needs: security-gate
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Build and Test
        run: mvn clean package -B

      - name: Publish Test Report
        uses: dorny/test-reporter@v3
        if: always()
        with:
          name: JUnit Tests
          path: target/surefire-reports/*.xml
          reporter: java-junit

      - name: Upload JAR Artifact
        uses: actions/upload-artifact@v4
        with:
          name: java-app-jar
          path: target/*.jar
          retention-days: 30

  # ========== STAGE 4: DOCKER BUILD, SCAN & PUSH ==========

  docker:
    name: Docker Build, Scan & Push
    runs-on: ubuntu-latest
    needs: build
    permissions:
      contents: read
      packages: write
      security-events: write
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v3

      - name: Build Docker Image (local)
        uses: docker/build-push-action@v6
        with:
          context: .
          load: true
          tags: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          cache-from: type=gha
          cache-to: type=gha,mode=max

      # --- Container Scan: Table output for logs ---
      - name: Trivy Container Scan - Table
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'table'
          severity: 'CRITICAL,HIGH'

      # --- Container Scan: JSON output for quality gate ---
      - name: Trivy Container Scan - JSON
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'json'
          output: 'trivy-image-results.json'
          severity: 'CRITICAL,HIGH'

      # --- Container Scan: SARIF for Security tab ---
      - name: Trivy Container Scan - SARIF
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'sarif'
          output: 'trivy-image-results.sarif'
          severity: 'CRITICAL,HIGH'

      - name: Upload Container Scan SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-image-results.sarif
          category: trivy-container
        continue-on-error: true

      - name: Upload Container Scan Artifacts
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-container-scan-report
          path: |
            trivy-image-results.json
            trivy-image-results.sarif
          retention-days: 30

      # --- Quality Gate: Parse JSON and count vulns ---
      - name: Count Container Vulnerabilities
        id: container-check
        run: |
          CRITICAL=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="CRITICAL")] | length' trivy-image-results.json)
          HIGH=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="HIGH")] | length' trivy-image-results.json)
          TOTAL=$((CRITICAL + HIGH))
          echo "critical=$CRITICAL" >> "$GITHUB_OUTPUT"
          echo "high=$HIGH" >> "$GITHUB_OUTPUT"
          echo "total=$TOTAL" >> "$GITHUB_OUTPUT"
          echo "=========================================="
          echo "  CONTAINER SCAN RESULTS"
          echo "  Critical : $CRITICAL"
          echo "  High     : $HIGH"
          echo "  Total    : $TOTAL"
          echo "=========================================="

      - name: Quality Gate - Container Scan
        if: steps.container-check.outputs.total != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - IMAGE CVEs FOUND"
          echo "=========================================="
          echo "  Critical : ${{ steps.container-check.outputs.critical }}"
          echo "  High     : ${{ steps.container-check.outputs.high }}"
          echo "=========================================="
          echo "  Image will NOT be pushed to registry."
          echo "  Fix base image or suppress false positives."
          echo "=========================================="
          exit 1

      # --- Push only if container scan passed ---
      - name: Login to GHCR
        uses: docker/login-action@v3
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUB_TOKEN }}

      - name: Extract metadata
        id: meta
        uses: docker/metadata-action@v5
        with:
          images: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}
          tags: |
            type=sha,prefix=
            type=raw,value=latest,enable={{is_default_branch}}

      - name: Push Docker Image
        uses: docker/build-push-action@v6
        with:
          context: .
          push: true
          tags: ${{ steps.meta.outputs.tags }}
          labels: ${{ steps.meta.outputs.labels }}
          cache-from: type=gha
          cache-to: type=gha,mode=max

  # ========== STAGE 5: FINAL SUMMARY ==========

  pipeline-summary:
    name: Pipeline Summary
    runs-on: ubuntu-latest
    needs: [gitleaks, sca, codeql, security-gate, build, docker]
    if: always()
    steps:
      - name: Pipeline Result
        run: |
          echo "=========================================="
          echo "  DEVSECOPS PIPELINE SUMMARY"
          echo "=========================================="
          echo ""
          echo "  SECURITY SCANS"
          echo "  ─────────────────────────────────"
          echo "  Gitleaks (Secrets) : ${{ needs.gitleaks.result }}"
          echo "  Trivy (SCA)       : ${{ needs.sca.result }}"
          echo "  CodeQL (SAST)     : ${{ needs.codeql.result }}"
          echo "  Security Gate     : ${{ needs.security-gate.result }}"
          echo ""
          echo "  BUILD & DELIVERY"
          echo "  ─────────────────────────────────"
          echo "  Build & Test      : ${{ needs.build.result }}"
          echo "  Docker & Push     : ${{ needs.docker.result }}"
          echo "=========================================="

          if [[ "${{ needs.docker.result }}" == "success" ]]; then
            echo ""
            echo "  IMAGE PUSHED SUCCESSFULLY"
            echo "  ghcr.io/${{ github.repository }}:latest"
            echo "=========================================="
          else
            echo ""
            echo "  PIPELINE FAILED"
            echo "  Image was NOT pushed to registry."
            echo "=========================================="
            exit 1
          fi


Fix the codes
--
app.java

package com.example;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Sum: " + app.add(5, 3));
    }
}

delete the code in the repo
---
githuib repo  -- secret.txt delete file

false postive in trivy ignore
---

Create a .trivyignore file in root

# Container image false positives - baselined on 2026-03-31

# gnutls - DoS via crafted ClientHello
CVE-2026-1584

# libpng - heap buffer overflow
CVE-2026-25646

# libpng - use-after-free
CVE-2026-33416

# libpng - out-of-bounds read/write
CVE-2026-33636

# zlib - buffer overflow in untgz utility
CVE-2026-22184

update the workflow to use this file
---
name: DevSecOps Pipeline

on:
  workflow_dispatch:

env:
  REGISTRY: ghcr.io
  IMAGE_NAME: ${{ github.repository }}

jobs:

  # ========== STAGE 1: SECURITY SCANS (parallel) ==========

  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 1

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
          GITLEAKS_ARGUMENTS: --log-opts=-1
        continue-on-error: true

      - name: Upload Gitleaks SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: gitleaks
        continue-on-error: true

      - name: Upload Gitleaks Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Secrets
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "  Check Security tab or download"
          echo "  gitleaks-report artifact for details."
          echo "=========================================="
          exit 1

  sca:
    name: SCA - Trivy Dependency Scan
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Run Trivy SCA Scan
        id: trivy
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'table'
          severity: 'CRITICAL,HIGH'
          exit-code: '1'
          trivyignores: .trivyignore
        continue-on-error: true

      - name: Run Trivy SARIF Report
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-sca-results.sarif'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      - name: Upload Trivy SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-sca-results.sarif
          category: trivy-sca
        continue-on-error: true

      - name: Upload Trivy Report Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-sca-report
          path: trivy-sca-results.sarif
          retention-days: 30

      - name: Quality Gate - SCA
        if: steps.trivy.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - DEPENDENCY CVEs"
          echo "  HIGH/CRITICAL vulnerabilities found"
          echo "  in project dependencies."
          echo "=========================================="
          exit 1

  codeql:
    name: SAST - CodeQL Analysis
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Initialize CodeQL
        uses: github/codeql-action/init@v3
        with:
          languages: java-kotlin
          queries: security-and-quality

      - name: Build for CodeQL
        run: mvn clean package -DskipTests -B

      - name: Perform CodeQL Analysis
        uses: github/codeql-action/analyze@v3
        with:
          category: codeql-java
          output: codeql-results

      - name: Count CodeQL Alerts
        id: codeql-check
        if: always()
        run: |
          ALERT_COUNT=$(jq '[.runs[].results[]] | length' codeql-results/*.sarif)
          echo "alert_count=$ALERT_COUNT" >> "$GITHUB_OUTPUT"
          echo "CodeQL found $ALERT_COUNT alert(s)"

      - name: Quality Gate - SAST
        if: steps.codeql-check.outputs.alert_count != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CODE ISSUES FOUND"
          echo "  CodeQL found ${{ steps.codeql-check.outputs.alert_count }} alert(s)"
          echo "  Check Security tab > Code scanning"
          echo "  for detailed findings."
          echo "=========================================="
          exit 1

  # ========== STAGE 2: SECURITY GATE ==========

  security-gate:
    name: Security Quality Gate
    runs-on: ubuntu-latest
    needs: [gitleaks, sca, codeql]
    if: always()
    steps:
      - name: Evaluate scan results
        run: |
          echo "=========================================="
          echo "  SECURITY SCAN SUMMARY"
          echo "=========================================="
          echo "  Gitleaks (Secrets) : ${{ needs.gitleaks.result }}"
          echo "  Trivy (SCA)       : ${{ needs.sca.result }}"
          echo "  CodeQL (SAST)     : ${{ needs.codeql.result }}"
          echo "=========================================="

          if [[ "${{ needs.gitleaks.result }}" != "success" || \
                "${{ needs.sca.result }}" != "success" || \
                "${{ needs.codeql.result }}" != "success" ]]; then
            echo ""
            echo "  PIPELINE BLOCKED - Fix issues first"
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED - Proceeding to build"
          echo "=========================================="

  # ========== STAGE 3: BUILD & TEST ==========

  build:
    name: Build & Test
    runs-on: ubuntu-latest
    needs: security-gate
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Build and Test
        run: mvn clean package -B

      - name: Publish Test Report
        uses: dorny/test-reporter@v3
        if: always()
        with:
          name: JUnit Tests
          path: target/surefire-reports/*.xml
          reporter: java-junit

      - name: Upload JAR Artifact
        uses: actions/upload-artifact@v4
        with:
          name: java-app-jar
          path: target/*.jar
          retention-days: 30

  # ========== STAGE 4: DOCKER BUILD, SCAN & PUSH ==========

  docker:
    name: Docker Build, Scan & Push
    runs-on: ubuntu-latest
    needs: build
    permissions:
      contents: read
      packages: write
      security-events: write
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v3

      - name: Build Docker Image (local)
        uses: docker/build-push-action@v6
        with:
          context: .
          load: true
          tags: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          cache-from: type=gha
          cache-to: type=gha,mode=max

      # --- Container Scan: Table output for logs ---
      - name: Trivy Container Scan - Table
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'table'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      # --- Container Scan: JSON output for quality gate ---
      - name: Trivy Container Scan - JSON
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'json'
          output: 'trivy-image-results.json'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      # --- Container Scan: SARIF for Security tab ---
      - name: Trivy Container Scan - SARIF
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'sarif'
          output: 'trivy-image-results.sarif'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      - name: Upload Container Scan SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-image-results.sarif
          category: trivy-container
        continue-on-error: true

      - name: Upload Container Scan Artifacts
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-container-scan-report
          path: |
            trivy-image-results.json
            trivy-image-results.sarif
          retention-days: 30

      # --- Quality Gate: Parse JSON and count vulns ---
      - name: Count Container Vulnerabilities
        id: container-check
        run: |
          CRITICAL=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="CRITICAL")] | length' trivy-image-results.json)
          HIGH=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="HIGH")] | length' trivy-image-results.json)
          TOTAL=$((CRITICAL + HIGH))
          echo "critical=$CRITICAL" >> "$GITHUB_OUTPUT"
          echo "high=$HIGH" >> "$GITHUB_OUTPUT"
          echo "total=$TOTAL" >> "$GITHUB_OUTPUT"
          echo "=========================================="
          echo "  CONTAINER SCAN RESULTS"
          echo "  Critical : $CRITICAL"
          echo "  High     : $HIGH"
          echo "  Total    : $TOTAL"
          echo "=========================================="

      - name: Quality Gate - Container Scan
        if: steps.container-check.outputs.total != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - IMAGE CVEs FOUND"
          echo "=========================================="
          echo "  Critical : ${{ steps.container-check.outputs.critical }}"
          echo "  High     : ${{ steps.container-check.outputs.high }}"
          echo "=========================================="
          echo "  Image will NOT be pushed to registry."
          echo "  Fix base image or suppress false positives."
          echo "=========================================="
          exit 1

      # --- Push only if container scan passed ---
      - name: Login to GHCR
        uses: docker/login-action@v3
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUB_TOKEN }}

      - name: Extract metadata
        id: meta
        uses: docker/metadata-action@v5
        with:
          images: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}
          tags: |
            type=sha,prefix=
            type=raw,value=latest,enable={{is_default_branch}}

      - name: Push Docker Image
        uses: docker/build-push-action@v6
        with:
          context: .
          push: true
          tags: ${{ steps.meta.outputs.tags }}
          labels: ${{ steps.meta.outputs.labels }}
          cache-from: type=gha
          cache-to: type=gha,mode=max

  # ========== STAGE 5: FINAL SUMMARY ==========

  pipeline-summary:
    name: Pipeline Summary
    runs-on: ubuntu-latest
    needs: [gitleaks, sca, codeql, security-gate, build, docker]
    if: always()
    steps:
      - name: Pipeline Result
        run: |
          echo "=========================================="
          echo "  DEVSECOPS PIPELINE SUMMARY"
          echo "=========================================="
          echo ""
          echo "  SECURITY SCANS"
          echo "  ─────────────────────────────────"
          echo "  Gitleaks (Secrets) : ${{ needs.gitleaks.result }}"
          echo "  Trivy (SCA)       : ${{ needs.sca.result }}"
          echo "  CodeQL (SAST)     : ${{ needs.codeql.result }}"
          echo "  Security Gate     : ${{ needs.security-gate.result }}"
          echo ""
          echo "  BUILD & DELIVERY"
          echo "  ─────────────────────────────────"
          echo "  Build & Test      : ${{ needs.build.result }}"
          echo "  Docker & Push     : ${{ needs.docker.result }}"
          echo "=========================================="

          if [[ "${{ needs.docker.result }}" == "success" ]]; then
            echo ""
            echo "  IMAGE PUSHED SUCCESSFULLY"
            echo "  ghcr.io/${{ github.repository }}:latest"
            echo "=========================================="
          else
            echo ""
            echo "  PIPELINE FAILED"
            echo "  Image was NOT pushed to registry."
            echo "=========================================="
            exit 1
          fi


save -- commit and push -- run the workflow



name: DAST pipeline

on:
  workflow_dispatch:

env:
  REGISTRY: ghcr.io
  IMAGE_NAME: ${{ github.repository }}

jobs:

  # ========== STAGE 1: SECURITY SCANS (parallel) ==========

  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 1

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: .gitleaks.toml
          GITLEAKS_ARGUMENTS: --log-opts=-1
        continue-on-error: true

      - name: Upload Gitleaks SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: gitleaks
        continue-on-error: true

      - name: Upload Gitleaks Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: gitleaks-report
          path: results.sarif
          retention-days: 30

      - name: Quality Gate - Secrets
        if: steps.gitleaks.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "  Check Security tab or download"
          echo "  gitleaks-report artifact for details."
          echo "=========================================="
          exit 1

  sca:
    name: SCA - Trivy Dependency Scan
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Run Trivy SCA Scan
        id: trivy
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'table'
          severity: 'CRITICAL,HIGH'
          exit-code: '1'
          trivyignores: .trivyignore
        continue-on-error: true

      - name: Run Trivy SARIF Report
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-sca-results.sarif'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      - name: Upload Trivy SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-sca-results.sarif
          category: trivy-sca
        continue-on-error: true

      - name: Upload Trivy Report Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-sca-report
          path: trivy-sca-results.sarif
          retention-days: 30

      - name: Quality Gate - SCA
        if: steps.trivy.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - DEPENDENCY CVEs"
          echo "  HIGH/CRITICAL vulnerabilities found"
          echo "  in project dependencies."
          echo "=========================================="
          exit 1

  codeql:
    name: SAST - CodeQL Analysis
    runs-on: ubuntu-latest
    permissions:
      security-events: write
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Initialize CodeQL
        uses: github/codeql-action/init@v3
        with:
          languages: java-kotlin
          queries: security-and-quality

      - name: Build for CodeQL
        run: mvn clean package -DskipTests -B

      - name: Perform CodeQL Analysis
        uses: github/codeql-action/analyze@v3
        with:
          category: codeql-java
          output: codeql-results

      - name: Count CodeQL Alerts
        id: codeql-check
        if: always()
        run: |
          ALERT_COUNT=$(jq '[.runs[].results[]] | length' codeql-results/*.sarif)
          echo "alert_count=$ALERT_COUNT" >> "$GITHUB_OUTPUT"
          echo "CodeQL found $ALERT_COUNT alert(s)"

      - name: Quality Gate - SAST
        if: steps.codeql-check.outputs.alert_count != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - CODE ISSUES FOUND"
          echo "  CodeQL found ${{ steps.codeql-check.outputs.alert_count }} alert(s)"
          echo "  Check Security tab > Code scanning"
          echo "  for detailed findings."
          echo "=========================================="
          exit 1

  # ========== STAGE 2: SECURITY GATE ==========

  security-gate:
    name: Security Quality Gate
    runs-on: ubuntu-latest
    needs: [gitleaks, sca, codeql]
    if: always()
    steps:
      - name: Evaluate scan results
        run: |
          echo "=========================================="
          echo "  SECURITY SCAN SUMMARY"
          echo "=========================================="
          echo "  Gitleaks (Secrets) : ${{ needs.gitleaks.result }}"
          echo "  Trivy (SCA)       : ${{ needs.sca.result }}"
          echo "  CodeQL (SAST)     : ${{ needs.codeql.result }}"
          echo "=========================================="

          if [[ "${{ needs.gitleaks.result }}" != "success" || \
                "${{ needs.sca.result }}" != "success" || \
                "${{ needs.codeql.result }}" != "success" ]]; then
            echo ""
            echo "  PIPELINE BLOCKED - Fix issues first"
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED - Proceeding to build"
          echo "=========================================="

  # ========== STAGE 3: BUILD & TEST ==========

  build:
    name: Build & Test
    runs-on: ubuntu-latest
    needs: security-gate
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      - name: Build and Test
        run: mvn clean package -B

      - name: Publish Test Report
        uses: dorny/test-reporter@v3
        if: always()
        with:
          name: JUnit Tests
          path: target/surefire-reports/*.xml
          reporter: java-junit

      - name: Upload JAR Artifact
        uses: actions/upload-artifact@v4
        with:
          name: java-app-jar
          path: target/*.jar
          retention-days: 30

  # ========== STAGE 4: DOCKER BUILD, SCAN & PUSH ==========

  docker:
    name: Docker Build, Scan & Push
    runs-on: ubuntu-latest
    needs: build
    permissions:
      contents: read
      packages: write
      security-events: write
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v3

      - name: Build Docker Image (local)
        uses: docker/build-push-action@v6
        with:
          context: .
          load: true
          tags: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          cache-from: type=gha
          cache-to: type=gha,mode=max

      # --- Container Scan: Table output for logs ---
      - name: Trivy Container Scan - Table
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'table'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      # --- Container Scan: JSON output for quality gate ---
      - name: Trivy Container Scan - JSON
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'json'
          output: 'trivy-image-results.json'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      # --- Container Scan: SARIF for Security tab ---
      - name: Trivy Container Scan - SARIF
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}:scan
          format: 'sarif'
          output: 'trivy-image-results.sarif'
          severity: 'CRITICAL,HIGH'
          trivyignores: .trivyignore

      - name: Upload Container Scan SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-image-results.sarif
          category: trivy-container
        continue-on-error: true

      - name: Upload Container Scan Artifacts
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-container-scan-report
          path: |
            trivy-image-results.json
            trivy-image-results.sarif
          retention-days: 30

      # --- Quality Gate: Parse JSON and count vulns ---
      - name: Count Container Vulnerabilities
        id: container-check
        run: |
          CRITICAL=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="CRITICAL")] | length' trivy-image-results.json)
          HIGH=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="HIGH")] | length' trivy-image-results.json)
          TOTAL=$((CRITICAL + HIGH))
          echo "critical=$CRITICAL" >> "$GITHUB_OUTPUT"
          echo "high=$HIGH" >> "$GITHUB_OUTPUT"
          echo "total=$TOTAL" >> "$GITHUB_OUTPUT"
          echo "=========================================="
          echo "  CONTAINER SCAN RESULTS"
          echo "  Critical : $CRITICAL"
          echo "  High     : $HIGH"
          echo "  Total    : $TOTAL"
          echo "=========================================="

      - name: Quality Gate - Container Scan
        if: steps.container-check.outputs.total != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - IMAGE CVEs FOUND"
          echo "=========================================="
          echo "  Critical : ${{ steps.container-check.outputs.critical }}"
          echo "  High     : ${{ steps.container-check.outputs.high }}"
          echo "=========================================="
          echo "  Image will NOT be pushed to registry."
          echo "  Fix base image or suppress false positives."
          echo "=========================================="
          exit 1

      # --- Push only if container scan passed ---
      - name: Login to GHCR
        uses: docker/login-action@v3
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUB_TOKEN }}

      - name: Extract metadata
        id: meta
        uses: docker/metadata-action@v5
        with:
          images: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}
          tags: |
            type=sha,prefix=
            type=raw,value=latest,enable={{is_default_branch}}

      - name: Push Docker Image
        uses: docker/build-push-action@v6
        with:
          context: .
          push: true
          tags: ${{ steps.meta.outputs.tags }}
          labels: ${{ steps.meta.outputs.labels }}
          cache-from: type=gha
          cache-to: type=gha,mode=max

# ========== STAGE 5: DAST - ZAP Scan ==========
  dast:
    name: DAST - ZAP Baseline Scan
    runs-on: ubuntu-latest
    needs: docker
    permissions:
      security-events: write
      contents: read
      issues: write
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: ZAP Baseline Scan
        id: zap
        uses: zaproxy/action-baseline@v0.14.0
        with:
          target: 'https://juice-shop.herokuapp.com'
          rules_file_name: 'zap-rules.tsv'
          allow_issue_writing: true
          fail_action: true
          artifact_name: zap-report
        continue-on-error: true

      - name: Upload ZAP SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: report_sarif.json
          category: zap-dast
        continue-on-error: true

      - name: Quality Gate - DAST
        if: steps.zap.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - DAST ISSUES FOUND"
          echo "  Check the ZAP report artifact or"
          echo "  Security tab for details."
          echo "=========================================="
          exit 1
    
  # ========== STAGE 5: FINAL SUMMARY ==========
  pipeline-summary:
    name: Pipeline Summary
    runs-on: ubuntu-latest
    needs: [gitleaks, sca, codeql, security-gate, build, docker, dast]
    if: always()
    steps:
      - name: Pipeline Result
        run: |
          echo "=========================================="
          echo "  DEVSECOPS PIPELINE SUMMARY"
          echo "=========================================="
          echo ""
          echo "  SECURITY SCANS"
          echo "  ─────────────────────────────────"
          echo "  Gitleaks (Secrets) : ${{ needs.gitleaks.result }}"
          echo "  Trivy (SCA)       : ${{ needs.sca.result }}"
          echo "  CodeQL (SAST)     : ${{ needs.codeql.result }}"
          echo "  Security Gate     : ${{ needs.security-gate.result }}"
          echo ""
          echo "  BUILD & DELIVERY"
          echo "  ─────────────────────────────────"
          echo "  Build & Test      : ${{ needs.build.result }}"
          echo "  Docker & Push     : ${{ needs.docker.result }}"
          echo ""
          echo "  RUNTIME SECURITY"
          echo "  ─────────────────────────────────"
          echo "  ZAP DAST          : ${{ needs.dast.result }}"
          echo "=========================================="
