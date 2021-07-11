const readline = require('readline');
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
let input = []
rl.on("line", function(line){
    input.push(line);
}).on("close", function(){
    let A = Number(input[0]);
    let B = Number(input[1]);
    if (0 < A && 0 < B) {
        console.log(1)
    } else if (0 > A && 0 < B){
        console.log(2)
    } else if (0 > A && 0 > B){
        console.log(3)
    } else if (0 < A && 0 > B){
        console.log(4)
    } else {
        console.log('0 is not valid')
    }
})