//
//  ViewController.swift
//  Lab1
//
//  Created by Michelle Galetti on 9/8/19.
//  Copyright © 2019 Michelle Galetti. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var animalImage: UIImageView!
    
    
    
    @IBOutlet weak var messageText: UILabel!
    
    @IBAction func changeImage(_ sender: UIButton) {
        /*Statistics found on https://www.avma.org/KB/Resources/Statistics/Pages/Market-research-statistics-US-pet-ownership.aspx */
            if sender.tag == 1{
                animalImage.image = UIImage(named: "kitten")
                messageText.text = "30.4% of the US population also love cats!"
            }
            else if sender.tag == 2{
                animalImage.image = UIImage(named: "puppy")
                messageText.text = "36.5% of the US population also love dogs!"
            }
            else if sender.tag == 3{
                animalImage.image = UIImage(named: "horse")
                messageText.text = "Horses are expensive animals!"
            }
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        animalImage.isUserInteractionEnabled = true
        // Do any additional setup after loading the view.
    }


}

