# currency-conversion-service

GIT commands after creating repo in git
echo "# currency-conversion-service" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/moumitacloud08/currency-conversion-service.git
git push -u origin main


----------------

Feign makes it easy to call other microservices
It provides integration with Ribbon which is client site load balancing framework

--------
API URI:- 
http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000
http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/1000