const readline = require('readline');
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
let input
rl.on("line", function(line){
    input = parseInt(line)
    rl.close();
}).on("close", function(){
    if (input%4 === 0) {
        if (input%100 !== 0){
            console.log(1)
        } else {
            if (input%400 === 0) {
                console.log(1)
            } else {
                console.log(0)
            }
        }
    } else {
        console.log(0)
    }
})