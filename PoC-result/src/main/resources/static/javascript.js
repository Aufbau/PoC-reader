//get the result-container div
let rContainer = document.getElementById("result-container");

const main = () => {
	//query api
	fetch("/api/results")
		.then((res) => {
			//deserialise the response json
			return res.json();
		})
		.then((results) => {
			//log it(just to see that stuff is actually happening)
			console.log(results);

			//clear out previous elements inside result-container
			rContainer.innerHTML = "";

			results.forEach((element) => {
				//create a div.result for every element in the respose array
				//and append it inside result-container

				let rdiv = document.createElement("div");
				rdiv.setAttribute("class", "result");
				rdiv.innerHTML = `${element.name.toString()}: ${element.count.toString()}`;
				rContainer.appendChild(rdiv);
			});
		})
		.then(() => {
			//poll again after 2 seconds!
			setTimeout(() => {
				main();
			}, 2000);
		});
};

main();
