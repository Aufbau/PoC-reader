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

			let count = 0;

			let styleArr = ["bg-danger", "bg-warning"];

			results.forEach((element) => {
				//create a div.result for every element in the respose array
				//and append it inside result-container

				let rdiv = document.createElement("div");
				rdiv.setAttribute("class", "result h4 ps-2 py-2");
				rdiv.innerHTML = `${element.name.toString()}: ${element.count.toString()}`;

				//styling
				rdiv.className += " " + styleArr[count];

				//for alternate colors
				count += 1;
				count = count % 2;

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
