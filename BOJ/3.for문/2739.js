const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
let input
rl.on("line", function(line){
    input = parseInt(line)
    if ( 1 <= input && input <= 9) {
        for ( i=1; i<10; i++) {
            console.log(input+" * "+i+" = "+(input*i))
        }
    } else {
        console.log('not valid')
    }
}).on("close", function(){
    process.exit()
})