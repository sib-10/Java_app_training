Welcome to Github Action Trainings
===

Lab URL	https://digitallabs.palmeto.co.in


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

set 1 link
---
https://github.com/sathishbabudevops/githubtraining-3103


test coverage
---


app.java contenet
---
package com.example;

public class App {

    // --- Arithmetic ---
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    // --- String utilities ---
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + name.trim() + "!";
    }

    // --- Number classification ---
    public String classifyNumber(int n) {
        if (n > 0) {
            return "positive";
        } else if (n < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    // --- FizzBuzz (classic branch-heavy example) ---
    public String fizzBuzz(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be positive");
        }
        if (n % 15 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }

    // --- Intentionally UNTESTED method (to show coverage gaps) ---
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative input not allowed");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Sum: " + app.add(5, 3));
        System.out.println("Palindrome: " + app.isPalindrome("racecar"));
        System.out.println("FizzBuzz(15): " + app.fizzBuzz(15));
    }
}


apptest.java conetent
---

package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    // --- Arithmetic tests ---
    @Test
    void testAdd() {
        assertEquals(8, app.add(5, 3));
        assertEquals(0, app.add(-1, 1));
    }

    @Test
    void testSubtract() {
        assertEquals(2, app.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, app.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, app.divide(5, 2), 0.001);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> app.divide(5, 0));
    }

    // --- String utility tests ---
    @Test
    void testIsPalindromeTrue() {
        assertTrue(app.isPalindrome("racecar"));
        assertTrue(app.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(app.isPalindrome("hello"));
    }

    @Test
    void testIsPalindromeNull() {
        assertFalse(app.isPalindrome(null));
    }

    @Test
    void testGreetWithName() {
        assertEquals("Hello, Alice!", app.greet("Alice"));
    }

    @Test
    void testGreetWithNull() {
        assertEquals("Hello, World!", app.greet(null));
    }

    @Test
    void testGreetWithBlank() {
        assertEquals("Hello, World!", app.greet("   "));
    }

    // --- Number classification tests ---
    @Test
    void testClassifyPositive() {
        assertEquals("positive", app.classifyNumber(42));
    }

    @Test
    void testClassifyNegative() {
        assertEquals("negative", app.classifyNumber(-7));
    }

    @Test
    void testClassifyZero() {
        assertEquals("zero", app.classifyNumber(0));
    }

    @Test
    void testIsEven() {
        assertTrue(app.isEven(4));
        assertFalse(app.isEven(3));
    }

    // --- FizzBuzz tests ---
    @Test
    void testFizzBuzzFizz() {
        assertEquals("Fizz", app.fizzBuzz(9));
    }

    @Test
    void testFizzBuzzBuzz() {
        assertEquals("Buzz", app.fizzBuzz(10));
    }

    @Test
    void testFizzBuzzFizzBuzz() {
        assertEquals("FizzBuzz", app.fizzBuzz(15));
    }

    @Test
    void testFizzBuzzNumber() {
        assertEquals("7", app.fizzBuzz(7));
    }

    @Test
    void testFizzBuzzInvalid() {
        assertThrows(IllegalArgumentException.class, () -> app.fizzBuzz(0));
    }

    // NOTE: factorial() is intentionally NOT tested here
    //       to demonstrate a coverage gap in the JaCoCo report.
}

update pom.xml with unit ttrest coverage
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
        <jacoco.version>0.8.12</jacoco.version>
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

            <!-- ========================================= -->
            <!-- JaCoCo – Code Coverage                    -->
            <!-- ========================================= -->
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>${jacoco.version}</version>
                <executions>

                    <!-- 1) Instrument: Attaches the JaCoCo agent before tests run -->
                    <execution>
                        <id>prepare-agent</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>

                    <!-- 2) Report: Generates HTML/XML/CSV reports after tests -->
                    <execution>
                        <id>report</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>

                    <!-- 3) OPTIONAL: Enforce minimum coverage thresholds -->
                    <!--    Uncomment this block to fail the build if     -->
                    <!--    coverage drops below the configured limits.   -->
                    <!--
                    <execution>
                        <id>check</id>
                        <goals>
                            <goal>check</goal>
                        </goals>
                        <configuration>
                            <rules>
                                <rule>
                                    <element>BUNDLE</element>
                                    <limits>
                                        <limit>
                                            <counter>LINE</counter>
                                            <value>COVEREDRATIO</value>
                                            <minimum>0.80</minimum>
                                        </limit>
                                        <limit>
                                            <counter>BRANCH</counter>
                                            <value>COVEREDRATIO</value>
                                            <minimum>0.70</minimum>
                                        </limit>
                                    </limits>
                                </rule>
                            </rules>
                        </configuration>
                    </execution>
                    -->

                </executions>
            </plugin>
        </plugins>
    </build>

</project>

github workflow
---
name: Java Build + Code Coverage

on:
  workflow_dispatch:

jobs:
  build-and-coverage:
    name: Build, Test & Coverage
    runs-on: ubuntu-latest

    steps:
      # ── Checkout ──────────────────────────────────
      - name: Checkout code
        uses: actions/checkout@v4

      # ── JDK Setup ────────────────────────────────
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'
          cache: 'maven'

      # ── Build + Test + JaCoCo Report ─────────────
      # 'verify' phase runs: compile → test → jacoco:report
      - name: Build and generate coverage report
        run: mvn clean verify

      # ── Publish JUnit Test Results ───────────────
      - name: Publish Test Report
        uses: dorny/test-reporter@v1
        if: always()
        with:
          name: JUnit Test Results
          path: target/surefire-reports/*.xml
          reporter: java-junit

      # ── Upload JaCoCo HTML report as artifact ────
      - name: Upload JaCoCo Coverage Report
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-coverage-report
          path: target/site/jacoco/

      # ── Post coverage summary to PR ──────────────
      - name: JaCoCo Coverage Summary (PR comment)
        uses: madrapps/jacoco-report@v1.7.1
        if: github.event_name == 'pull_request'
        with:
          paths: target/site/jacoco/jacoco.xml
          token: ${{ secrets.GITHUB_TOKEN }}
          min-coverage-overall: 60
          min-coverage-changed-files: 80
          title: "## Code Coverage Report"
          update-comment: true

      # ── Print quick coverage summary to log ──────
      - name: Print coverage summary
        run: |
          echo "═══════════════════════════════════════"
          echo "  JaCoCo Coverage Report Generated"
          echo "═══════════════════════════════════════"
          echo ""
          echo "HTML report: target/site/jacoco/index.html"
          echo "XML  report: target/site/jacoco/jacoco.xml"
          echo "CSV  report: target/site/jacoco/jacoco.csv"
          echo ""
          if [ -f target/site/jacoco/jacoco.csv ]; then
            echo "── Per-class summary (from CSV) ──"
            column -t -s',' target/site/jacoco/jacoco.csv
          fi
          
save -- commit --push and run

running jobs on self hosted runner
---

prepre seld hosted runner
---

ubundu node

sudo su

# Update system
sudo apt update && sudo apt upgrade -y

# Git (required by actions/checkout)
sudo apt install -y git

# JDK 17
sudo apt install -y openjdk-17-jdk
java -version

# Maven
sudo apt install -y maven
mvn -version

# Python3 + bc (for coverage parsing script)
sudo apt install -y python3 bc

# (Optional) Clean workspace tool
sudo apt install -y jq curl

swotch to github-runner users and restart the service
---

su github-runner
cd
cd actions-runner
sudo ./svc.sh stop
sudo ./svc.sh start

create aworkflow to run on linux runner
--

filename: linuxrunner.yml

name: Java Build + Coverage (Linux)

on:
  workflow_dispatch:

jobs:
  build-linux:
    name: Build, Test & Coverage
    runs-on: [self-hosted, ubunturunner]

    steps:
      # ── Clean workspace (raw self-hosted runners don't auto-clean) ──
      - name: Clean workspace
        run: |
          echo "Cleaning workspace: $GITHUB_WORKSPACE"
          rm -rf "$GITHUB_WORKSPACE"/*

      # ── Checkout ──
      - name: Checkout code
        uses: actions/checkout@v4

      # ── Verify tools are available ──
      - name: Verify prerequisites
        run: |
          echo "=== Java ==="
          java -version
          echo ""
          echo "=== Maven ==="
          mvn -version
          echo ""
          echo "=== Git ==="
          git --version

      # ── Build + Test + JaCoCo ──
      - name: Build and generate coverage
        run: mvn clean verify

      # ── Publish JUnit results ──
      - name: Publish Test Report
        uses: dorny/test-reporter@v1
        if: always()
        with:
          name: JUnit Tests (Linux)
          path: target/surefire-reports/*.xml
          reporter: java-junit

      # ── Upload JaCoCo HTML report ──
      - name: Upload JaCoCo Coverage Report
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-coverage-linux
          path: target/site/jacoco/

      # ── Coverage threshold check (unstable warning) ──
      - name: Check coverage threshold
        run: |
          COVERAGE=$(python3 -c "
          import xml.etree.ElementTree as ET
          tree = ET.parse('target/site/jacoco/jacoco.xml')
          counter = tree.findall('.//counter[@type=\"LINE\"]')[-1]
          missed = int(counter.get('missed'))
          covered = int(counter.get('covered'))
          print(round(covered / (covered + missed) * 100, 2))
          ")
          echo "==============================="
          echo "  Line Coverage: ${COVERAGE}%"
          echo "==============================="
          if (( $(echo "$COVERAGE < 80" | bc -l) )); then
            echo "::warning::UNSTABLE - Coverage is ${COVERAGE}%, below 80% target"
          else
            echo "::notice::Coverage is ${COVERAGE}% - target met!"
          fi

      # ── Post coverage summary on PR ──
      - name: JaCoCo PR Comment
        uses: madrapps/jacoco-report@v1.7.1
        if: github.event_name == 'pull_request'
        with:
          paths: target/site/jacoco/jacoco.xml
          token: ${{ secrets.GITHUB_TOKEN }}
          min-coverage-overall: 60
          min-coverage-changed-files: 80
          title: "## Code Coverage Report (Linux)"
          update-comment: true
          
save -- commit -- push -- run the workflow

windows runner
---
open power shell as administrator

# Install Chocolatey (package manager)
Set-ExecutionPolicy Bypass -Scope Process -Force
[System.Net.ServicePointManager]::SecurityProtocol = [System.Net.SecurityProtocolType]::Tls12
iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

install .net framework
---
windows run -- server manager -- local server -- ie enhanced policy -- off

open internet explorer and downal and run the exe

https://download.visualstudio.microsoft.com/download/pr/2d6bb6b2-226a-4baa-bdec-798822606ff1/8494001c276a4b96804cde7829c04d7f/ndp48-x86-x64-allos-enu.exe

on prompt restart vm

open power shell as administrator

# Git
choco install git -y

# JDK 17
choco install temurin17 -y

# Maven
choco install maven -y

# Refresh PATH
close and reopen the powershell

# Verify
java -version
mvn -version
git --version

restart github agent service
---

windows serach -- serviuces -- github agent -- restart

add workflow file
---

filename: windowsrunner.yml

name: Java Build + Coverage (Windows)

on:
  workflow_dispatch:

jobs:
  build-windows:
    name: Build, Test & Coverage
    runs-on: [self-hosted, windowsrunner]

    steps:
      # ── Clean workspace (raw self-hosted runners don't auto-clean) ──
      - name: Clean workspace
        run: |
          Write-Host "Cleaning workspace: $env:GITHUB_WORKSPACE"
          if (Test-Path "$env:GITHUB_WORKSPACE\*") {
            Remove-Item -Recurse -Force "$env:GITHUB_WORKSPACE\*"
          }
        shell: powershell

      # ── Checkout ──
      - name: Checkout code
        uses: actions/checkout@v4

      # ── Verify tools are available ──
      - name: Verify prerequisites
        run: |
          Write-Host "=== Java ==="
          java -version
          Write-Host ""
          Write-Host "=== Maven ==="
          mvn -version
          Write-Host ""
          Write-Host "=== Git ==="
          git --version
        shell: powershell

      # ── Build + Test + JaCoCo ──
      - name: Build and generate coverage
        run: mvn clean verify
        shell: cmd

      # ── Publish JUnit results ──
      - name: Publish Test Report
        uses: dorny/test-reporter@v1
        if: always()
        with:
          name: JUnit Tests (Windows)
          path: target/surefire-reports/*.xml
          reporter: java-junit

      # ── Upload JaCoCo HTML report ──
      - name: Upload JaCoCo Coverage Report
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-coverage-windows
          path: target/site/jacoco/

      # ── Coverage threshold check (unstable warning) ──
      - name: Check coverage threshold
        run: |
          [xml]$jacoco = Get-Content "target/site/jacoco/jacoco.xml"
          $counters = $jacoco.report.counter | Where-Object { $_.type -eq "LINE" }
          $missed = [int]$counters.missed
          $covered = [int]$counters.covered
          $total = $missed + $covered
          $coverage = [math]::Round(($covered / $total) * 100, 2)

          Write-Host "==============================="
          Write-Host "  Line Coverage: $coverage%"
          Write-Host "==============================="

          if ($coverage -lt 80) {
            Write-Host "::warning::UNSTABLE - Coverage is $coverage%, below 80% target"
          } else {
            Write-Host "::notice::Coverage is $coverage% - target met!"
          }
        shell: powershell

      # ── Post coverage summary on PR ──
      - name: JaCoCo PR Comment
        uses: madrapps/jacoco-report@v1.7.1
        if: github.event_name == 'pull_request'
        with:
          paths: target/site/jacoco/jacoco.xml
          token: ${{ secrets.GITHUB_TOKEN }}
          min-coverage-overall: 60
          min-coverage-changed-files: 80
          title: "## Code Coverage Report (Windows)"
          update-comment: true
          
save -- commit -- push -- eun workflow


dynamic runners on kubernetes
---
https://github.com/actions/actions-runner-controller

clone this repo
---

sudo su

cd

git clone https://github.com/sathishbabudevops/github-docker-runner.git

install docker
--
# Update system
sudo apt update && sudo apt upgrade -y

# Install Docker
sudo apt install -y docker.io docker-compose-v2

# Start Docker and enable on boot
sudo systemctl start docker
sudo systemctl enable docker

validate docker
--
docker run hello-world
docker compose version

Create a token
---
navigate to below usrl in the same browser where you are loged into git hub
----
https://github.com/settings/tokens

generate new token -- generate new token (classic

name: PAT
No expiry
all access

add the token to env file
---
cd github-docker-runner

cp .env.example .env

nano .env

update the token and repo details

CTRL + o to save

Ctrl + x to exit

Build the Runner Image
----

chmod +x manage.sh

./manage.sh build

List the images
---
docker images

Start 3 runners for parallel jobs
---
./manage.sh start 3

list the containers
---
docker ps

see the runners in github
---
repo -- settings -- actions -- runners

Modified ehtry point.sh
----
#!/bin/bash
set -e

# ── Validate required env vars ──
if [ -z "$GITHUB_TOKEN" ] || [ -z "$GITHUB_REPO" ]; then
  echo "ERROR: GITHUB_TOKEN and GITHUB_REPO are required"
  echo "  GITHUB_TOKEN = Personal Access Token (repo scope)"
  echo "  GITHUB_REPO  = owner/repo (e.g. sathishbabudevops/javaapp)"
  exit 1
fi

RUNNER_NAME="${RUNNER_NAME:-docker-runner-$(hostname | tail -c 8)}"
RUNNER_LABELS="${RUNNER_LABELS:-self-hosted,linux,docker}"

echo "============================================"
echo "  GitHub Actions Dynamic Runner"
echo "============================================"
echo "  Repo:   ${GITHUB_REPO}"
echo "  Runner: ${RUNNER_NAME}"
echo "  Labels: ${RUNNER_LABELS}"
echo "  Mode:   Ephemeral (single job, auto-cleanup)"
echo "============================================"

# ── Get registration token from GitHub API ──
echo "Requesting registration token..."
REG_TOKEN=$(curl -s -X POST \
  -H "Authorization: token ${GITHUB_TOKEN}" \
  -H "Accept: application/vnd.github.v3+json" \
  "https://api.github.com/repos/${GITHUB_REPO}/actions/runners/registration-token" | jq -r '.token')

if [ "$REG_TOKEN" == "null" ] || [ -z "$REG_TOKEN" ]; then
  echo "ERROR: Failed to get registration token. Check your GITHUB_TOKEN and GITHUB_REPO."
  exit 1
fi

echo "Registration token acquired."

# ── Cleanup function: remove runner on exit ──
cleanup() {
  echo ""
  echo "Removing runner..."
  REMOVE_TOKEN=$(curl -s -X POST \
    -H "Authorization: token ${GITHUB_TOKEN}" \
    -H "Accept: application/vnd.github.v3+json" \
    "https://api.github.com/repos/${GITHUB_REPO}/actions/runners/remove-token" | jq -r '.token')
  ./config.sh remove --token "$REMOVE_TOKEN" 2>/dev/null || true
  echo "Runner removed. Container will exit."
}

trap cleanup EXIT SIGTERM SIGINT

# ── Configure runner ──
./config.sh \
  --url "https://github.com/${GITHUB_REPO}" \
  --token "$REG_TOKEN" \
  --name "$RUNNER_NAME" \
  --labels "$RUNNER_LABELS" \
  --ephemeral \
  --unattended \
  --replace \
  --disableupdate

# ── Start runner (ephemeral = exits after one job) ──
echo ""
echo "Runner is ready. Waiting for a job..."
./run.sh

Modified docker file
---
FROM ubuntu:22.04

ARG RUNNER_VERSION=2.333.0
ARG DEBIAN_FRONTEND=noninteractive

# ── Core dependencies ──
RUN apt-get update && apt-get install -y \
    curl \
    git \
    jq \
    sudo \
    unzip \
    wget \
    bc \
    python3 \
    openjdk-17-jdk \
    maven \
    docker.io \
    && rm -rf /var/lib/apt/lists/*

# ── Create runner user ──
RUN useradd -m -s /bin/bash runner && \
    usermod -aG sudo runner && \
    usermod -aG docker runner && \
    echo "runner ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

# ── Install GitHub Actions Runner ──
WORKDIR /home/runner/actions-runner
RUN curl -o actions-runner.tar.gz -L \
    "https://github.com/actions/runner/releases/download/v${RUNNER_VERSION}/actions-runner-linux-x64-${RUNNER_VERSION}.tar.gz" && \
    tar xzf actions-runner.tar.gz && \
    rm actions-runner.tar.gz && \
    ./bin/installdependencies.sh && \
    chown -R runner:runner /home/runner

# ── Disable auto-update (version controlled via image rebuild) ──
ENV AGENT_TOOLSDIRECTORY=/opt/hostedtoolcache
RUN mkdir -p /opt/hostedtoolcache && chown runner:runner /opt/hostedtoolcache

# ── Entrypoint script ──
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

USER runner
ENTRYPOINT ["/entrypoint.sh"]

stop and rebuild and start the containers
---
./manage.sh stop
./manage.sh build
./manage.sh start 3

Create work flow
---
filename: dynamic.yml

name: Java Build + Coverage (Dynamic Docker Runner)

on:
  workflow_dispatch:

jobs:
  build:
    name: Build, Test & Coverage
    runs-on: [self-hosted, linux, docker, dynamic]
    # ↑ Matches the labels set in the Docker runner

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Verify environment
        run: |
          echo "=== Runner Info ==="
          echo "Runner name: $RUNNER_NAME"
          echo "Runner OS:   $(uname -a)"
          echo ""
          echo "=== Java ==="
          java -version
          echo ""
          echo "=== Maven ==="
          mvn -version

      - name: Build and generate coverage
        run: mvn clean verify

      - name: Publish Test Report
        uses: dorny/test-reporter@v1
        if: always()
        with:
          name: JUnit Tests (Docker)
          path: target/surefire-reports/*.xml
          reporter: java-junit

      - name: Upload JaCoCo Coverage Report
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-coverage-docker
          path: target/site/jacoco/

      - name: Check coverage threshold
        run: |
          COVERAGE=$(python3 -c "
          import xml.etree.ElementTree as ET
          tree = ET.parse('target/site/jacoco/jacoco.xml')
          counter = tree.findall('.//counter[@type=\"LINE\"]')[-1]
          missed = int(counter.get('missed'))
          covered = int(counter.get('covered'))
          print(round(covered / (covered + missed) * 100, 2))
          ")
          echo "==============================="
          echo "  Line Coverage: ${COVERAGE}%"
          echo "==============================="
          if (( $(echo "$COVERAGE < 80" | bc -l) )); then
            echo "::warning::UNSTABLE - Coverage is ${COVERAGE}%, below 80% target"
          else
            echo "::notice::Coverage is ${COVERAGE}% - target met!"
          fi
          
Github migrate
----
https://docs.github.com/en/actions/tutorials/migrate-to-github-actions/automated-migrations/jenkins-migration
https://docs.github.com/en/actions/tutorials/migrate-to-github-actions/automated-migrations

Functional test using selenium
---
replace pom.xml

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

        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.18.1</version>
            <scope>test</scope>
        </dependency>

        <!-- WebDriverManager - auto manages browser drivers -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.7.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
            </plugin>
        </plugins>
    </build>

    <!-- Selenium profile - runs only selenium tests -->
    <profiles>
        <profile>
            <id>selenium</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>3.1.2</version>
                        <configuration>
                            <includes>
                                <include>**/selenium/**/*.java</include>
                            </includes>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>

</project>

Create the folder structure: src/test/java/com/example/selenium/

base test class
---

File: src/test/java/com/example/selenium/BaseTest.java
---

package com.example.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://demo.testfire.net";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void takeScreenshot(String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path targetDir = Paths.get("target", "screenshots");
            Files.createDirectories(targetDir);
            Files.copy(screenshot.toPath(), targetDir.resolve(testName + ".png"));
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}

homepage test class
---

File: src/test/java/com/example/selenium/HomePageTest.java
----


package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class HomePageTest extends BaseTest {

    @Test
    @DisplayName("Home page should load successfully")
    void homePageLoads() {
        driver.get(BASE_URL);
        takeScreenshot("home-page");

        String title = driver.getTitle();
        assertFalse(title.isEmpty(), "Page title should not be empty");
        System.out.println("Page title: " + title);
    }

    @Test
    @DisplayName("Home page should have navigation links")
    void homePageHasNavigation() {
        driver.get(BASE_URL);

        WebElement body = driver.findElement(By.tagName("body"));
        assertNotNull(body, "Page body should exist");

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Sign In") || pageSource.contains("Login") || pageSource.contains("login"),
                "Page should have a login option");
        takeScreenshot("navigation-check");
    }

    @Test
    @DisplayName("Page should return HTTP 200")
    void pageReturnsOk() {
        driver.get(BASE_URL);

        // If page loads without error, it returned 200
        assertFalse(driver.getTitle().contains("404"), "Page should not return 404");
        assertFalse(driver.getTitle().contains("Error"), "Page should not have error");
        takeScreenshot("http-status-check");
    }
}

login page test class
---

File: src/test/java/com/example/selenium/LoginPageTest.java
---

package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest extends BaseTest {

    @Test
    @DisplayName("Login page should load")
    void loginPageLoads() {
        driver.get(BASE_URL + "/login.jsp");
        takeScreenshot("login-page");

        String pageSource = driver.getPageSource();
        assertTrue(
            pageSource.contains("username") || pageSource.contains("Username") || pageSource.contains("uid"),
            "Login page should have username field"
        );
    }

    @Test
    @DisplayName("Login with invalid credentials should fail")
    void loginWithInvalidCredentials() {
        driver.get(BASE_URL + "/login.jsp");

        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginBtn = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("invaliduser");
        password.sendKeys("invalidpass");
        loginBtn.click();

        takeScreenshot("invalid-login");

        String pageSource = driver.getPageSource();
        assertTrue(
            pageSource.contains("error") || pageSource.contains("Error") || pageSource.contains("Login Failed"),
            "Should show error for invalid credentials"
        );
    }

    @Test
    @DisplayName("Login with valid credentials should succeed")
    void loginWithValidCredentials() {
        driver.get(BASE_URL + "/login.jsp");

        // testfire.net demo credentials
        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginBtn = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("jsmith");
        password.sendKeys("Demo1234");
        loginBtn.click();

        takeScreenshot("valid-login");

        String pageSource = driver.getPageSource();
        assertTrue(
            pageSource.contains("Account Summary") || pageSource.contains("Sign Off") || pageSource.contains("Logout"),
            "Should show account page after login"
        );
    }
}

search test class
---
File: src/test/java/com/example/selenium/SearchTest.java
---

package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest extends BaseTest {

    @Test
    @DisplayName("Search functionality should work")
    void searchReturnsResults() {
        driver.get(BASE_URL);

        WebElement searchBox = driver.findElement(By.id("query"));
        searchBox.sendKeys("loan");
        searchBox.submit();

        takeScreenshot("search-results");

        String pageSource = driver.getPageSource();
        assertFalse(pageSource.isEmpty(), "Search should return a page");
    }

    @Test
    @DisplayName("Empty search should be handled gracefully")
    void emptySearchHandled() {
        driver.get(BASE_URL);

        WebElement searchBox = driver.findElement(By.id("query"));
        searchBox.sendKeys("");
        searchBox.submit();

        takeScreenshot("empty-search");

        // Page should not crash
        assertFalse(driver.getTitle().contains("Error"), "Empty search should not cause error");
    }
}

Create workflow
---
.github/workflows/selenium-tests.yml:

name: Selenium Functional Tests

on:
  workflow_dispatch:

jobs:
  selenium-tests:
    name: Selenium UI Tests
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

      - name: Set up Chrome
        uses: browser-actions/setup-chrome@v1
        with:
          chrome-version: 'stable'

      - name: Set up ChromeDriver
        uses: nanasess/setup-chromedriver@v2

      - name: Run Selenium Tests
        run: |
          export DISPLAY=:99
          chromedriver --port=4444 &
          mvn test -Pselenium -B

      - name: Publish Test Report
        uses: dorny/test-reporter@v3
        if: always()
        with:
          name: Selenium Test Results
          path: target/surefire-reports/*.xml
          reporter: java-junit

      - name: Upload Screenshots on Failure
        if: failure()
        uses: actions/upload-artifact@v4
        with:
          name: selenium-failure-screenshots
          path: target/screenshots/
          retention-days: 30

      - name: Upload Test Report
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: selenium-test-report
          path: target/surefire-reports/
          retention-days: 30
          
save -- commit -- push and run workflow

Load testing using jmeter
---
Create the JMeter test plan. 

Create folder jmeter/ in repo root and add jmeter/load-test-plan.jmx

<?xml version="1.0" encoding="UTF-8"?>
<jmeterTestPlan version="1.2" properties="5.0" jmeter="5.6.3">
  <hashTree>
    <TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Load Test Plan" enabled="true">
      <elementProp name="TestPlan.user_defined_variables" elementType="Arguments">
        <collectionProp name="Arguments.arguments"/>
      </elementProp>
    </TestPlan>
    <hashTree>

      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Users" enabled="true">
        <stringProp name="ThreadGroup.num_threads">${__P(threads,10)}</stringProp>
        <stringProp name="ThreadGroup.ramp_time">${__P(rampup,10)}</stringProp>
        <boolProp name="ThreadGroup.scheduler">true</boolProp>
        <stringProp name="ThreadGroup.duration">${__P(duration,60)}</stringProp>
        <stringProp name="ThreadGroup.delay">0</stringProp>
        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControlPanel" testclass="LoopController">
          <boolProp name="LoopController.continue_forever">false</boolProp>
          <intProp name="LoopController.loops">-1</intProp>
        </elementProp>
      </ThreadGroup>
      <hashTree>

        <CookieManager guiclass="CookiePanel" testclass="CookieManager" testname="Cookie Manager" enabled="true">
          <collectionProp name="CookieManager.cookies"/>
          <boolProp name="CookieManager.clearEachIteration">false</boolProp>
        </CookieManager>
        <hashTree/>

        <!-- Home Page -->
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="01 - Home Page" enabled="true">
          <stringProp name="HTTPSampler.domain">demo.testfire.net</stringProp>
          <stringProp name="HTTPSampler.port">443</stringProp>
          <stringProp name="HTTPSampler.protocol">https</stringProp>
          <stringProp name="HTTPSampler.path">/</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="AssertionGui" testclass="ResponseAssertion" testname="Assert 200" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="49586">200</stringProp>
            </collectionProp>
            <stringProp name="Assertion.test_field">Assertion.response_code</stringProp>
            <intProp name="Assertion.test_type">8</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>

        <ConstantTimer guiclass="ConstantTimerGui" testclass="ConstantTimer" testname="Think Time" enabled="true">
          <stringProp name="ConstantTimer.delay">1000</stringProp>
        </ConstantTimer>
        <hashTree/>

        <!-- Login Page -->
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="02 - Login Page" enabled="true">
          <stringProp name="HTTPSampler.domain">demo.testfire.net</stringProp>
          <stringProp name="HTTPSampler.port">443</stringProp>
          <stringProp name="HTTPSampler.protocol">https</stringProp>
          <stringProp name="HTTPSampler.path">/login.jsp</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree>
          <ResponseAssertion guiclass="AssertionGui" testclass="ResponseAssertion" testname="Assert 200" enabled="true">
            <collectionProp name="Asserion.test_strings">
              <stringProp name="49586">200</stringProp>
            </collectionProp>
            <stringProp name="Assertion.test_field">Assertion.response_code</stringProp>
            <intProp name="Assertion.test_type">8</intProp>
          </ResponseAssertion>
          <hashTree/>
        </hashTree>

        <ConstantTimer guiclass="ConstantTimerGui" testclass="ConstantTimer" testname="Think Time 2" enabled="true">
          <stringProp name="ConstantTimer.delay">1000</stringProp>
        </ConstantTimer>
        <hashTree/>

        <!-- Login Submit -->
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="03 - Login Submit" enabled="true">
          <stringProp name="HTTPSampler.domain">demo.testfire.net</stringProp>
          <stringProp name="HTTPSampler.port">443</stringProp>
          <stringProp name="HTTPSampler.protocol">https</stringProp>
          <stringProp name="HTTPSampler.path">/doLogin</stringProp>
          <stringProp name="HTTPSampler.method">POST</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.postBodyRaw">false</boolProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments">
            <collectionProp name="Arguments.arguments">
              <elementProp name="uid" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.name">uid</stringProp>
                <stringProp name="Argument.value">jsmith</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
              </elementProp>
              <elementProp name="passw" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.name">passw</stringProp>
                <stringProp name="Argument.value">Demo1234</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
              </elementProp>
              <elementProp name="btnSubmit" elementType="HTTPArgument">
                <boolProp name="HTTPArgument.always_encode">true</boolProp>
                <stringProp name="Argument.name">btnSubmit</stringProp>
                <stringProp name="Argument.value">Login</stringProp>
                <stringProp name="Argument.metadata">=</stringProp>
              </elementProp>
            </collectionProp>
          </elementProp>
        </HTTPSamplerProxy>
        <hashTree/>

        <ConstantTimer guiclass="ConstantTimerGui" testclass="ConstantTimer" testname="Think Time 3" enabled="true">
          <stringProp name="ConstantTimer.delay">2000</stringProp>
        </ConstantTimer>
        <hashTree/>

        <!-- Account Summary -->
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="04 - Account Summary" enabled="true">
          <stringProp name="HTTPSampler.domain">demo.testfire.net</stringProp>
          <stringProp name="HTTPSampler.port">443</stringProp>
          <stringProp name="HTTPSampler.protocol">https</stringProp>
          <stringProp name="HTTPSampler.path">/bank/main.jsp</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree/>

        <ConstantTimer guiclass="ConstantTimerGui" testclass="ConstantTimer" testname="Think Time 4" enabled="true">
          <stringProp name="ConstantTimer.delay">1000</stringProp>
        </ConstantTimer>
        <hashTree/>

        <!-- Search -->
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="05 - Search" enabled="true">
          <stringProp name="HTTPSampler.domain">demo.testfire.net</stringProp>
          <stringProp name="HTTPSampler.port">443</stringProp>
          <stringProp name="HTTPSampler.protocol">https</stringProp>
          <stringProp name="HTTPSampler.path">/search.jsp?query=loan</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree/>

        <ConstantTimer guiclass="ConstantTimerGui" testclass="ConstantTimer" testname="Think Time 5" enabled="true">
          <stringProp name="ConstantTimer.delay">1000</stringProp>
        </ConstantTimer>
        <hashTree/>

        <!-- Logout -->
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="06 - Logout" enabled="true">
          <stringProp name="HTTPSampler.domain">demo.testfire.net</stringProp>
          <stringProp name="HTTPSampler.port">443</stringProp>
          <stringProp name="HTTPSampler.protocol">https</stringProp>
          <stringProp name="HTTPSampler.path">/logout.jsp</stringProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <stringProp name="HTTPSampler.connect_timeout">5000</stringProp>
          <stringProp name="HTTPSampler.response_timeout">30000</stringProp>
        </HTTPSamplerProxy>
        <hashTree/>

      </hashTree>
    </hashTree>
  </hashTree>
</jmeterTestPlan>

JMeter load testing workflow. 
----

Create .github/workflows/load-test.yml

name: Load Test - JMeter

on:
  workflow_dispatch:
    inputs:
      threads:
        description: 'Number of concurrent users'
        required: true
        default: '10'
        type: string
      duration:
        description: 'Test duration in seconds'
        required: true
        default: '60'
        type: string
      rampup:
        description: 'Ramp-up period in seconds'
        required: true
        default: '10'
        type: string
      target_url:
        description: 'Target URL to test'
        required: true
        default: 'https://demo.testfire.net'
        type: string

jobs:
  load-test:
    name: JMeter Load Test
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Install JMeter
        run: |
          JMETER_VERSION=5.6.3
          wget -q https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-${JMETER_VERSION}.tgz
          tar -xzf apache-jmeter-${JMETER_VERSION}.tgz
          echo "$PWD/apache-jmeter-${JMETER_VERSION}/bin" >> $GITHUB_PATH
          echo "JMETER_HOME=$PWD/apache-jmeter-${JMETER_VERSION}" >> $GITHUB_ENV

      - name: Verify JMeter Installation
        run: jmeter --version

      - name: Run JMeter Load Test
        id: jmeter
        run: |
          mkdir -p results

          jmeter -n \
            -t jmeter/load-test-plan.jmx \
            -Jthreads=${{ github.event.inputs.threads || '10' }} \
            -Jduration=${{ github.event.inputs.duration || '60' }} \
            -Jrampup=${{ github.event.inputs.rampup || '10' }} \
            -Jtarget_url=${{ github.event.inputs.target_url || 'https://demo.testfire.net' }} \
            -l results/test-results.jtl \
            -j results/jmeter.log \
            -e -o results/html-report

      - name: Parse Results & Quality Gate
        id: quality-gate
        run: |
          # Parse JTL results
          TOTAL=$(tail -n +2 results/test-results.jtl | wc -l)
          ERRORS=$(tail -n +2 results/test-results.jtl | awk -F',' '{if($8=="false") count++} END {print count+0}')
          ERROR_RATE=$(echo "scale=2; $ERRORS * 100 / $TOTAL" | bc)

          # Calculate average response time
          AVG_RESPONSE=$(tail -n +2 results/test-results.jtl | awk -F',' '{sum+=$2; count++} END {printf "%.0f", sum/count}')

          # Calculate 95th percentile
          P95=$(tail -n +2 results/test-results.jtl | awk -F',' '{print $2}' | sort -n | awk '{a[NR]=$1} END {print a[int(NR*0.95)]}')

          # Calculate throughput (requests per second)
          FIRST_TS=$(tail -n +2 results/test-results.jtl | head -1 | awk -F',' '{print $1}')
          LAST_TS=$(tail -n +2 results/test-results.jtl | tail -1 | awk -F',' '{print $1}')
          DURATION_MS=$((LAST_TS - FIRST_TS))
          if [ "$DURATION_MS" -gt 0 ]; then
            THROUGHPUT=$(echo "scale=2; $TOTAL * 1000 / $DURATION_MS" | bc)
          else
            THROUGHPUT=0
          fi

          echo "=========================================="
          echo "  JMETER LOAD TEST RESULTS"
          echo "=========================================="
          echo "  Total Requests     : $TOTAL"
          echo "  Failed Requests    : $ERRORS"
          echo "  Error Rate         : ${ERROR_RATE}%"
          echo "  Avg Response Time  : ${AVG_RESPONSE}ms"
          echo "  95th Percentile    : ${P95}ms"
          echo "  Throughput         : ${THROUGHPUT} req/sec"
          echo "=========================================="

          # Save to outputs
          echo "total=$TOTAL" >> "$GITHUB_OUTPUT"
          echo "errors=$ERRORS" >> "$GITHUB_OUTPUT"
          echo "error_rate=$ERROR_RATE" >> "$GITHUB_OUTPUT"
          echo "avg_response=$AVG_RESPONSE" >> "$GITHUB_OUTPUT"
          echo "p95=$P95" >> "$GITHUB_OUTPUT"
          echo "throughput=$THROUGHPUT" >> "$GITHUB_OUTPUT"

          # Quality Gate Thresholds
          MAX_ERROR_RATE=5
          MAX_AVG_RESPONSE=3000
          MAX_P95=5000

          GATE_PASSED=true

          if (( $(echo "$ERROR_RATE > $MAX_ERROR_RATE" | bc -l) )); then
            echo "FAIL: Error rate ${ERROR_RATE}% exceeds threshold ${MAX_ERROR_RATE}%"
            GATE_PASSED=false
          fi

          if [ "$AVG_RESPONSE" -gt "$MAX_AVG_RESPONSE" ]; then
            echo "FAIL: Avg response ${AVG_RESPONSE}ms exceeds threshold ${MAX_AVG_RESPONSE}ms"
            GATE_PASSED=false
          fi

          if [ "$P95" -gt "$MAX_P95" ]; then
            echo "FAIL: P95 ${P95}ms exceeds threshold ${MAX_P95}ms"
            GATE_PASSED=false
          fi

          echo "gate_passed=$GATE_PASSED" >> "$GITHUB_OUTPUT"

      - name: Quality Gate Decision
        if: steps.quality-gate.outputs.gate_passed == 'false'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED"
          echo "=========================================="
          echo "  Thresholds:"
          echo "    Max Error Rate    : 5%"
          echo "    Max Avg Response  : 3000ms"
          echo "    Max P95 Response  : 5000ms"
          echo ""
          echo "  Actual:"
          echo "    Error Rate        : ${{ steps.quality-gate.outputs.error_rate }}%"
          echo "    Avg Response      : ${{ steps.quality-gate.outputs.avg_response }}ms"
          echo "    P95 Response      : ${{ steps.quality-gate.outputs.p95 }}ms"
          echo "=========================================="
          exit 1

      - name: Create Summary
        if: always()
        run: |
          cat >> $GITHUB_STEP_SUMMARY << 'EOF'
          ## 📊 JMeter Load Test Results

          | Metric | Value | Threshold | Status |
          |--------|-------|-----------|--------|
          | Total Requests | ${{ steps.quality-gate.outputs.total }} | - | ℹ️ |
          | Error Rate | ${{ steps.quality-gate.outputs.error_rate }}% | < 5% | ${{ steps.quality-gate.outputs.error_rate > 5 && '❌' || '✅' }} |
          | Avg Response Time | ${{ steps.quality-gate.outputs.avg_response }}ms | < 3000ms | ${{ steps.quality-gate.outputs.avg_response > 3000 && '❌' || '✅' }} |
          | P95 Response Time | ${{ steps.quality-gate.outputs.p95 }}ms | < 5000ms | ${{ steps.quality-gate.outputs.p95 > 5000 && '❌' || '✅' }} |
          | Throughput | ${{ steps.quality-gate.outputs.throughput }} req/s | - | ℹ️ |

          **Configuration:** ${{ github.event.inputs.threads || '10' }} users, ${{ github.event.inputs.duration || '60' }}s duration, ${{ github.event.inputs.rampup || '10' }}s ramp-up
          EOF

      - name: Upload JMeter HTML Report
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: jmeter-html-report
          path: results/html-report/
          retention-days: 30

      - name: Upload JMeter Raw Results
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: jmeter-raw-results
          path: |
            results/test-results.jtl
            results/jmeter.log
          retention-days: 30
          
save -- commit push and  workflow

create a new enterprise trail
---
repo -- setting enterprise -- start trial get started with personal account

Enterprise name: {your name}-training

org: create without org

admin: your existing account

email : you existing account email

verify

accept trail term

verrify your mail 

skip billing

org : {your name}-training


swotch to your org
---

settings -- org -- your org

repo -- new repo

Set visibility to private
Check Add a README
Click Create repository

Go to shared repo
Click Settings
Scroll all the way down to Danger Zone
Click Change visibility
Change from Private to Internal
Confirm


After changing to Internal, go back to:

github.com/{your orgname}/shared-workflows/settings/actions
Now the "Access" section will appear
Select "Accessible from repositories in the enterprise level
Click Save

Create reusable work flow
---

code -- add file


.github/workflows/security-scan.

name: Reusable Security Scan

on:
  workflow_call:
    inputs:
      fetch-depth:
        description: 'Git fetch depth for gitleaks'
        required: false
        type: number
        default: 1
      trivy-severity:
        description: 'Trivy severity levels'
        required: false
        type: string
        default: 'CRITICAL,HIGH'
      codeql-language:
        description: 'CodeQL language'
        required: false
        type: string
        default: 'java-kotlin'
      java-version:
        description: 'Java version'
        required: false
        type: string
        default: '17'
      gitleaks-config:
        description: 'Gitleaks config file path'
        required: false
        type: string
        default: '.gitleaks.toml'
      trivyignore-file:
        description: 'Trivy ignore file path'
        required: false
        type: string
        default: '.trivyignore'
    outputs:
      gitleaks-result:
        description: 'Gitleaks scan result'
        value: ${{ jobs.gitleaks.result }}
      sca-result:
        description: 'SCA scan result'
        value: ${{ jobs.sca.result }}
      codeql-result:
        description: 'CodeQL scan result'
        value: ${{ jobs.codeql.result }}
      gate-result:
        description: 'Overall security gate result'
        value: ${{ jobs.security-gate.result }}

jobs:
  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: ${{ inputs.fetch-depth }}

      - name: Run Gitleaks
        id: gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          GITLEAKS_CONFIG: ${{ inputs.gitleaks-config }}
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
          severity: ${{ inputs.trivy-severity }}
          exit-code: '1'
          trivyignores: ${{ inputs.trivyignore-file }}
        continue-on-error: true

      - name: Run Trivy SARIF Report
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-sca-results.sarif'
          severity: ${{ inputs.trivy-severity }}
          trivyignores: ${{ inputs.trivyignore-file }}

      - name: Upload Trivy SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-sca-results.sarif
          category: trivy-sca
        continue-on-error: true

      - name: Upload Trivy Artifact
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

      - name: Set up JDK
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: ${{ inputs.java-version }}
          cache: 'maven'

      - name: Initialize CodeQL
        uses: github/codeql-action/init@v3
        with:
          languages: ${{ inputs.codeql-language }}
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
          echo "=========================================="
          exit 1

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
            echo "  PIPELINE BLOCKED"
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL SCANS PASSED"
          echo "=========================================="
          
add docker build work flow
---

new file .github/workflows/docker-build.yml

name: Reusable Docker Build & Push

on:
  workflow_call:
    inputs:
      image-name:
        description: 'Docker image name'
        required: true
        type: string
      dockerfile:
        description: 'Dockerfile path'
        required: false
        type: string
        default: './Dockerfile'
      trivy-severity:
        description: 'Trivy image scan severity'
        required: false
        type: string
        default: 'CRITICAL,HIGH'
      trivyignore-file:
        description: 'Trivy ignore file path'
        required: false
        type: string
        default: '.trivyignore'
    outputs:
      image-tag:
        description: 'Pushed image tag'
        value: ${{ jobs.docker.outputs.image-tag }}

jobs:
  docker:
    name: Docker Build, Scan & Push
    runs-on: ubuntu-latest
    permissions:
      contents: read
      packages: write
      security-events: write
    outputs:
      image-tag: ${{ steps.meta.outputs.tags }}
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v3

      - name: Build Docker Image (local)
        uses: docker/build-push-action@v6
        with:
          context: .
          file: ${{ inputs.dockerfile }}
          load: true
          tags: ghcr.io/${{ inputs.image-name }}:scan
          cache-from: type=gha
          cache-to: type=gha,mode=max

      - name: Trivy Container Scan - Table
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ghcr.io/${{ inputs.image-name }}:scan
          format: 'table'
          severity: ${{ inputs.trivy-severity }}
          trivyignores: ${{ inputs.trivyignore-file }}

      - name: Trivy Container Scan - JSON
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ghcr.io/${{ inputs.image-name }}:scan
          format: 'json'
          output: 'trivy-image-results.json'
          severity: ${{ inputs.trivy-severity }}
          trivyignores: ${{ inputs.trivyignore-file }}

      - name: Trivy Container Scan - SARIF
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          image-ref: ghcr.io/${{ inputs.image-name }}:scan
          format: 'sarif'
          output: 'trivy-image-results.sarif'
          severity: ${{ inputs.trivy-severity }}
          trivyignores: ${{ inputs.trivyignore-file }}

      - name: Upload Container Scan SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-image-results.sarif
          category: trivy-container
        continue-on-error: true

      - name: Upload Container Scan Artifact
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: trivy-container-scan-report
          path: trivy-image-results.json
          retention-days: 30

      - name: Count Container Vulnerabilities
        id: container-check
        run: |
          CRITICAL=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="CRITICAL")] | length' trivy-image-results.json)
          HIGH=$(jq '[.Results[]?.Vulnerabilities[]? | select(.Severity=="HIGH")] | length' trivy-image-results.json)
          TOTAL=$((CRITICAL + HIGH))
          echo "critical=$CRITICAL" >> "$GITHUB_OUTPUT"
          echo "high=$HIGH" >> "$GITHUB_OUTPUT"
          echo "total=$TOTAL" >> "$GITHUB_OUTPUT"

      - name: Quality Gate - Container Scan
        if: steps.container-check.outputs.total != '0'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - IMAGE CVEs"
          echo "  Critical : ${{ steps.container-check.outputs.critical }}"
          echo "  High     : ${{ steps.container-check.outputs.high }}"
          echo "=========================================="
          exit 1

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
          images: ghcr.io/${{ inputs.image-name }}
          tags: |
            type=sha,prefix=
            type=raw,value=latest,enable={{is_default_branch}}

      - name: Push Docker Image
        uses: docker/build-push-action@v6
        with:
          context: .
          file: ${{ inputs.dockerfile }}
          push: true
          tags: ${{ steps.meta.outputs.tags }}
          labels: ${{ steps.meta.outputs.labels }}
          cache-from: type=gha
          cache-to: type=gha,mode=max
          
Create java build workflow
---
.github/workflows/java-build.yml

name: Reusable Java Build & Test

on:
  workflow_call:
    inputs:
      java-version:
        description: 'Java version'
        required: false
        type: string
        default: '17'
      maven-goals:
        description: 'Maven goals'
        required: false
        type: string
        default: 'clean package -B'

jobs:
  build:
    name: Build & Test
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: ${{ inputs.java-version }}
          cache: 'maven'

      - name: Build and Test
        run: mvn ${{ inputs.maven-goals }}

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


Create a new org under enterprise
---

https://github.com/enterprises/{enterprisename}/organizations

new org

name: {yourname}-dev

Create a new repo under dev org
---

org -- repo -- new repo 
name: javaapp
visiblity: internal


Download javaapp code from your personal github to local
---
Downal java app as zip to c:\user\admin\repo\javaapp

delete all files in work flow

Open this in vs code
---
vscode -- new windows -- open folder c:\user\admin\repo\javaapp

Click on GIt icon -- click on the setup link which will take you to the page to download and install git

open command promt and navigate to c:\user\admin\repo\javaapp
---
git init
git add .
git config --global user.email "sathishbabudevops@gmail.com"
git config --global user.name "sathishbabudevops"
git commit -m "first commit"

git branch -M main

git remote add origin https://github.com/{your devorg}/{your repo name}.git

git push -u origin main

updated secret scan yaml
---
name: Reusable Security Scan

on:
  workflow_call:
    inputs:
      fetch-depth:
        description: 'Git fetch depth for gitleaks'
        required: false
        type: number
        default: 1
      trivy-severity:
        description: 'Trivy severity levels'
        required: false
        type: string
        default: 'CRITICAL,HIGH'
      codeql-language:
        description: 'CodeQL language'
        required: false
        type: string
        default: 'java-kotlin'
      java-version:
        description: 'Java version'
        required: false
        type: string
        default: '17'
      gitleaks-config:
        description: 'Gitleaks config file path'
        required: false
        type: string
        default: '.gitleaks.toml'
      trivyignore-file:
        description: 'Trivy ignore file path'
        required: false
        type: string
        default: '.trivyignore'
    outputs:
      gitleaks-result:
        description: 'Gitleaks scan result'
        value: ${{ jobs.gitleaks.result }}
      sca-result:
        description: 'SCA scan result'
        value: ${{ jobs.sca.result }}
      codeql-result:
        description: 'CodeQL scan result'
        value: ${{ jobs.codeql.result }}
      gate-result:
        description: 'Overall security gate result'
        value: ${{ jobs.security-gate.result }}

jobs:

  # ---- Job 1: Secret Scan ----
  gitleaks:
    name: Secret Scan (Gitleaks)
    runs-on: ubuntu-latest
    permissions:
      contents: read
      security-events: write
      actions: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: ${{ inputs.fetch-depth }}

      - name: Install Gitleaks
        run: |
          GITLEAKS_VERSION=8.24.3
          wget -qO- https://github.com/gitleaks/gitleaks/releases/download/v${GITLEAKS_VERSION}/gitleaks_${GITLEAKS_VERSION}_linux_x64.tar.gz | tar xz
          sudo mv gitleaks /usr/local/bin/

      - name: Run Gitleaks
        id: gitleaks
        run: |
          if [ -f "${{ inputs.gitleaks-config }}" ]; then
            CONFIG_FLAG="--config ${{ inputs.gitleaks-config }}"
          else
            CONFIG_FLAG=""
          fi

          gitleaks detect \
            --source . \
            $CONFIG_FLAG \
            --report-format sarif \
            --report-path results.sarif \
            --redact \
            -v && echo "leaks_found=false" >> "$GITHUB_OUTPUT" \
               || echo "leaks_found=true" >> "$GITHUB_OUTPUT"
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
        if: steps.gitleaks.outputs.leaks_found == 'true'
        run: |
          echo "=========================================="
          echo "  QUALITY GATE FAILED - SECRETS FOUND"
          echo "=========================================="
          exit 1

  # ---- Job 2: SCA ----
  sca:
    name: SCA - Trivy Dependency Scan
    runs-on: ubuntu-latest
    permissions:
      contents: read
      security-events: write
      actions: read
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
          severity: ${{ inputs.trivy-severity }}
          exit-code: '1'
          trivyignores: ${{ inputs.trivyignore-file }}
        continue-on-error: true

      - name: Run Trivy SARIF Report
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-sca-results.sarif'
          severity: ${{ inputs.trivy-severity }}
          trivyignores: ${{ inputs.trivyignore-file }}

      - name: Upload Trivy SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-sca-results.sarif
          category: trivy-sca
        continue-on-error: true

      - name: Upload Trivy Artifact
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
          echo "=========================================="
          exit 1

  # ---- Job 3: SAST ----
  codeql:
    name: SAST - CodeQL Analysis
    runs-on: ubuntu-latest
    permissions:
      contents: read
      security-events: write
      actions: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: ${{ inputs.java-version }}
          cache: 'maven'

      - name: Initialize CodeQL
        uses: github/codeql-action/init@v3
        with:
          languages: ${{ inputs.codeql-language }}
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
          echo "=========================================="
          exit 1

  # ---- Job 4: Gate ----
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
          echo "  ALL SCANS PASSED"
          echo "=========================================="


Create workflow in the dev org java app repo
---
.github/workflows/pipeline.yml


name: Full Pipeline (Cross-Org Shared Workflows)

on:
  workflow_dispatch:


jobs:

  # Stage 1: Security Scans (from {yourname}-training)
  security:
    name: Security Scans
    uses: {yourname}-training/shared-workflows/.github/workflows/security-scan.yml@main
    with:
      fetch-depth: 1
      trivy-severity: 'CRITICAL,HIGH'
      codeql-language: 'java-kotlin'
      java-version: '17'
    permissions:
      contents: read
      security-events: write
      actions: read

  # Stage 2: Build & Test (from {yourname}-training)
  build:
    name: Build & Test
    needs: security
    uses: {yourname}-training/shared-workflows/.github/workflows/java-build.yml@main
    with:
      java-version: '17'
      maven-goals: 'clean package -B'
    permissions:
      contents: read
      checks: write
      actions: read

  # Stage 3: Docker Build, Scan & Push (from {yourname}-training)
  docker:
    name: Docker Build & Push
    needs: build
    uses: {yourname}-training/shared-workflows/.github/workflows/docker-build.yml@main
    with:
      image-name: ${{ github.repository }}
      trivy-severity: 'CRITICAL,HIGH'
    permissions:
      contents: read
      packages: write
      security-events: write
      actions: read

  # Stage 4: Summary
  summary:
    name: Pipeline Summary
    runs-on: ubuntu-latest
    needs: [security, build, docker]
    if: always()
    permissions:
      contents: read
    steps:
      - name: Results
        run: |
          echo "=========================================="
          echo "  CROSS-ORG PIPELINE SUMMARY"
          echo "=========================================="
          echo "  Shared workflows : sathish-training"
          echo "  Running in       : sathish-dev01/javaapp"
          echo "=========================================="
          echo ""
          echo "  SECURITY SCANS"
          echo "  ─────────────────────────────────"
          echo "  Security Gate  : ${{ needs.security.result }}"
          echo ""
          echo "  BUILD & DELIVERY"
          echo "  ─────────────────────────────────"
          echo "  Build & Test   : ${{ needs.build.result }}"
          echo "  Docker & Push  : ${{ needs.docker.result }}"
          echo "=========================================="

          if [[ "${{ needs.docker.result }}" == "success" ]]; then
            echo ""
            echo "  ALL STAGES PASSED"
            echo "  Image: ghcr.io/${{ github.repository }}:latest"
            echo "=========================================="
          else
            echo ""
            echo "  PIPELINE FAILED"
            echo "=========================================="
            exit 1
          fi


delete login page file with secret
---
src/test/java/com/example/selenium

enable code security
---
repo -- security and quality -- code scanning alert -- setting 

run the work flow

Fork the repo
---
https://github.com/sathishbabudevops/pr-discord-bot

Create a Discord server

Here's how to get the webhook URL:

Step by step:

Click the ⚙️ gear icon next to the #general channel 
In the channel settings, click Integrations in the left sidebar
Click Webhooks
Click New Webhook

Click Copy Webhook URL
Then go to your repo → Settings → Secrets → Actions → New secret

Name: DISCORD_WEBHOOK_URL
Value: paste the webhook URL you copied

value: https://discord.com/api/webhooks/1488841777652699177/u8IIIiMHzk_6MidcddBJAVG8VXmsDBxK5XHK9OYULCTrJdC-csvChOjkIzsu6hA0sJ53

create a new branch in the forked repo
---
branch name dev

in the new branch create a file and commit 

compare and pull request

create pull request

Please complete the post assesment and feedback
-----

Post Assessment Link: https://forms.cloud.microsoft/r/spPCbgALgi

Feedback Link: https://forms.cloud.microsoft/r/ppi7T9FL00

Required Workflows
---
Goal: Force a security scan on every PR in every repo across training org — developers cannot skip or delete it

create the .github Repo in training org

Name:          .github
Visibility:    Internal (or Public for training visibility)
Add README:    Yes

Create a workflow on the repo
---
File path: .github/workflows/org-security-scan.yml

name: Org Required - Security Baseline

on:
  pull_request:
    branches: [main, develop]

permissions:
  contents: read

jobs:
  # ─── Org Check 1: No secrets in code ───
  org-secret-scan:
    name: "org/secret-scan"
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Run Gitleaks
        uses: gitleaks/gitleaks-action@v2
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}

  # ─── Org Check 2: No critical dependency vulnerabilities ───
  org-dependency-scan:
    name: "org/dependency-scan"
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4

      - name: Trivy FS Scan
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: fs
          format: table
          severity: CRITICAL,HIGH
          exit-code: 1

  # ─── Org Check 3: No prohibited licenses ───
  org-license-scan:
    name: "org/license-scan"
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4

      - name: Check licenses
        run: |
          PROHIBITED="GPL-3.0;AGPL-3.0;SSPL-1.0"

          if [ -f package.json ]; then
            echo "📦 Scanning Node.js licenses..."
            npx license-checker --failOn "$PROHIBITED" --summary
          fi

          if [ -f pom.xml ]; then
            echo "☕ Scanning Maven licenses..."
            mvn license:third-party-report -q || true
          fi

          echo "✅ License scan complete"
          
Create the required workflow in {trainingorg }/shared-workflows

Create .github/workflows/required-security.yml

name: Required Security Checks

on:
  pull_request:
    branches: [main]
  push:
    branches: [main]
  workflow_call:
    inputs:
      java-version:
        required: false
        type: string
        default: '17'

jobs:

  secret-scan:
    name: Required - Secret Scan
    runs-on: ubuntu-latest
    permissions:
      contents: read
      security-events: write
      actions: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4
        with:
          fetch-depth: 1

      - name: Install Gitleaks
        run: |
          GITLEAKS_VERSION=8.24.3
          wget -qO- https://github.com/gitleaks/gitleaks/releases/download/v${GITLEAKS_VERSION}/gitleaks_${GITLEAKS_VERSION}_linux_x64.tar.gz | tar xz
          sudo mv gitleaks /usr/local/bin/

      - name: Run Gitleaks
        id: gitleaks
        run: |
          if [ -f ".gitleaks.toml" ]; then
            CONFIG_FLAG="--config .gitleaks.toml"
          else
            CONFIG_FLAG=""
          fi

          gitleaks detect \
            --source . \
            $CONFIG_FLAG \
            --report-format sarif \
            --report-path results.sarif \
            --redact \
            -v && echo "leaks_found=false" >> "$GITHUB_OUTPUT" \
               || echo "leaks_found=true" >> "$GITHUB_OUTPUT"
        continue-on-error: true

      - name: Upload SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: results.sarif
          category: required-gitleaks
        continue-on-error: true

      - name: Enforce - No Secrets
        if: steps.gitleaks.outputs.leaks_found == 'true'
        run: |
          echo "=========================================="
          echo "  REQUIRED CHECK FAILED"
          echo "  Secrets detected in code"
          echo "  This is an org-enforced policy"
          echo "  Merge is BLOCKED until resolved"
          echo "=========================================="
          exit 1

  license-check:
    name: Required - License Compliance
    runs-on: ubuntu-latest
    permissions:
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Check for LICENSE file
        id: license
        run: |
          if [ -f "LICENSE" ] || [ -f "LICENSE.md" ] || [ -f "LICENSE.txt" ]; then
            echo "LICENSE file found"
            echo "has_license=true" >> "$GITHUB_OUTPUT"
          else
            echo "No LICENSE file found"
            echo "has_license=false" >> "$GITHUB_OUTPUT"
          fi

      - name: Enforce - License Required
        if: steps.license.outputs.has_license == 'false'
        run: |
          echo "=========================================="
          echo "  REQUIRED CHECK FAILED"
          echo "  Every repo must have a LICENSE file"
          echo "  This is an org-enforced policy"
          echo "  Merge is BLOCKED until resolved"
          echo "=========================================="
          exit 1

  code-standards:
    name: Required - Code Standards
    runs-on: ubuntu-latest
    permissions:
      contents: read
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Check for README
        id: readme
        run: |
          if [ -f "README.md" ] || [ -f "README.rst" ] || [ -f "README" ]; then
            echo "has_readme=true" >> "$GITHUB_OUTPUT"
          else
            echo "has_readme=false" >> "$GITHUB_OUTPUT"
          fi

      - name: Check for CODEOWNERS
        id: codeowners
        run: |
          if [ -f "CODEOWNERS" ] || [ -f ".github/CODEOWNERS" ] || [ -f "docs/CODEOWNERS" ]; then
            echo "has_codeowners=true" >> "$GITHUB_OUTPUT"
          else
            echo "has_codeowners=false" >> "$GITHUB_OUTPUT"
          fi

      - name: Check for branch protection files
        id: branchprotection
        run: |
          if [ -d ".github/workflows" ]; then
            WORKFLOW_COUNT=$(find .github/workflows -name "*.yml" -o -name "*.yaml" | wc -l)
            echo "workflow_count=$WORKFLOW_COUNT" >> "$GITHUB_OUTPUT"
          else
            echo "workflow_count=0" >> "$GITHUB_OUTPUT"
          fi

      - name: Compliance Summary
        run: |
          echo "=========================================="
          echo "  CODE STANDARDS CHECK"
          echo "=========================================="
          echo "  README        : ${{ steps.readme.outputs.has_readme }}"
          echo "  CODEOWNERS    : ${{ steps.codeowners.outputs.has_codeowners }}"
          echo "  Workflows     : ${{ steps.branchprotection.outputs.workflow_count }}"
          echo "=========================================="

      - name: Enforce - README Required
        if: steps.readme.outputs.has_readme == 'false'
        run: |
          echo "  REQUIRED CHECK FAILED"
          echo "  Every repo must have a README.md"
          exit 1

  dependency-scan:
    name: Required - Dependency Scan
    runs-on: ubuntu-latest
    permissions:
      contents: read
      security-events: write
      actions: read
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
          severity: 'CRITICAL'
          exit-code: '1'
        continue-on-error: true

      - name: Run Trivy SARIF
        if: always()
        uses: aquasecurity/trivy-action@master
        with:
          scan-type: 'fs'
          scan-ref: '.'
          format: 'sarif'
          output: 'trivy-results.sarif'
          severity: 'CRITICAL'

      - name: Upload SARIF
        if: always()
        uses: github/codeql-action/upload-sarif@v3
        with:
          sarif_file: trivy-results.sarif
          category: required-trivy
        continue-on-error: true

      - name: Enforce - No Critical CVEs
        if: steps.trivy.outcome == 'failure'
        run: |
          echo "=========================================="
          echo "  REQUIRED CHECK FAILED"
          echo "  Critical CVEs found in dependencies"
          echo "  This is an org-enforced policy"
          echo "  Merge is BLOCKED until resolved"
          echo "=========================================="
          exit 1

  compliance-gate:
    name: Required - Compliance Gate
    runs-on: ubuntu-latest
    needs: [secret-scan, license-check, code-standards, dependency-scan]
    if: always()
    steps:
      - name: Compliance Summary
        run: |
          echo "=========================================="
          echo "  ORG COMPLIANCE SUMMARY"
          echo "=========================================="
          echo "  Secret Scan      : ${{ needs.secret-scan.result }}"
          echo "  License Check    : ${{ needs.license-check.result }}"
          echo "  Code Standards   : ${{ needs.code-standards.result }}"
          echo "  Dependency Scan  : ${{ needs.dependency-scan.result }}"
          echo "=========================================="

          if [[ "${{ needs.secret-scan.result }}" != "success" || \
                "${{ needs.license-check.result }}" != "success" || \
                "${{ needs.code-standards.result }}" != "success" || \
                "${{ needs.dependency-scan.result }}" != "success" ]]; then
            echo ""
            echo "  COMPLIANCE FAILED"
            echo "  This repo does not meet org policies"
            echo "  PRs cannot be merged until resolved"
            echo "=========================================="
            exit 1
          fi

          echo ""
          echo "  ALL COMPLIANCE CHECKS PASSED"
          echo "=========================================="
          
Create the caller workflow that every repo must have
---
In {dev org}/javaapp create .github/workflows/required-checks.yml

name: Required Checks

on:
  pull_request:
    branches: [main]
  push:
    branches: [main]
  workflow_dispatch:

jobs:
  compliance:
    name: Org Compliance
    uses: sathish-training/shared-workflows/.github/workflows/required-security.yml@main
    permissions:
      contents: read
      security-events: write
      actions: read
      
Enforce via Repository Ruleset (the key part)**

This is what makes it **required** — not just a workflow that runs, but a check that **blocks merges**.

1. Go to `github.com/organizations/{training org}/settings/rules`
2. Click **New ruleset** → **New branch ruleset**
3. Configure:

| Setting | Value |
|---|---|
| Ruleset name | `Org Security Policy` |
| Enforcement | **Active** |
| Target | **All repositories** (or select specific ones) |
| Branch targeting | **Default branch** (`main`) |

4. Under **"Branch rules"** enable:

   **Require a pull request before merging** → set **Required approvals** to `1`

Require workflows to pass before merging
    add workflow shared-workflows/.github/workflows/required-security.yml
    
required code scanning

required code quality result

5. Click **Create**

Create a Branch -- make changes commit create PR .

merger should be allowed

remove required check yaml
---
