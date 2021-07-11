const readline = require('readline');
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
let input = []
rl.on("line", function(line){
    input = line.split(' ')
    let H = Number(input[0]);
    let M = Number(input[1]);
    if ( 0 <= H && H < 24) {
        if (45 <= M && M <= 59) {
            console.log(H+" "+(M-45))
        } else if (0 <= M && M < 45){
            if( H == 0 ) {
              console.log(23+" "+(M+15))
            } else {
                console.log(H-1+" "+(M+15))
            }
        } else {
                console.log('not valid')
        }
    } else {
        console.log('not valid')
    }
}).on("close", function(){
    process.exit();
})