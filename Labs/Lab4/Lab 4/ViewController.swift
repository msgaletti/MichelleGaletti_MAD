//
//  ViewController.swift
//  Lab 4
//
//  Created by Michelle Galetti on 10/1/19.
//  Copyright © 2019 Michelle Galetti. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var minAmount: UITextField!
    @IBOutlet weak var speedCalc: UILabel!
    
    @IBOutlet weak var withHillCalc: UILabel!
    @IBOutlet weak var mileStepper: UIStepper!

    @IBOutlet weak var mileLabel: UILabel!
  
    @IBOutlet weak var hillPercent: UITextField!
  
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    @IBAction func mileStepper(_ sender: UIStepper) {
        if mileStepper.value == 1 {
            mileLabel.text = "1 Mile"
        } else {
            mileLabel.text = String(format: "%.0f", mileStepper.value) + " Miles"
        }
        updateYourSpeed()
    }

    func updateYourSpeed() {
        var mins:Float //check amount
        var hillGrade:Float
        
        if minAmount.text!.isEmpty {
            mins = 0.0
        } else {
            mins = Float(minAmount.text!)!
        }
        if hillPercent.text!.isEmpty{
            hillGrade=0.0
        } else{
            hillGrade = Float(hillPercent.text!)!/100
        }
        let numberOfMiles = Float(mileStepper.value)
        //1.8 is the mph that is the average a runner runs on ground
        let hillMph = hillGrade*1.8
        var speedTotal: Float = 0.0
        var hillTotal: Float = 0.0
        let total = mins/60
        if numberOfMiles > 0 {
            speedTotal = Float(numberOfMiles)/total
            hillTotal = speedTotal*hillMph
        }else {
            //create a UIAlertController object
            let alert=UIAlertController(title: "Warning", message: "The number of miles must be greater than 0", preferredStyle: UIAlertController.Style.alert)
            //create a UIAlertAction object for the button
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction) //adds the alert action to the alert object
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.mileStepper.value = 1
                self.mileLabel.text? = "1 Mile"
                self.updateYourSpeed()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        } //end else
        
        let speedFormatter = NumberFormatter()
        speedFormatter.numberStyle=NumberFormatter.Style.decimal //set the number style
        speedCalc.text=speedFormatter.string(from: NSNumber(value: speedTotal))
        withHillCalc.text=speedFormatter.string(from: NSNumber(value: hillTotal))
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateYourSpeed()
    }
    
    override func viewDidLoad() {
        minAmount.delegate=self
        hillPercent.delegate=self
        super.viewDidLoad()
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillShow), name: UIResponder.keyboardWillShowNotification, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification, object: nil)
        
        let tap:UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        // Do any additional setup after loading the view.
    }
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }
    
    @objc func keyboardWillShow(notification: NSNotification){
        if let keyboardSize = (notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey]as? NSValue)?.cgRectValue {
            if self.view.frame.origin.y == 0{
                self.view.frame.origin.y -= keyboardSize.height
            }
        }
    }
    
    @objc func keyboardWillHide(notification: NSNotification){
        if ((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey]as? NSValue)?.cgRectValue) != nil {
            if self.view.frame.origin.y != 0{
                self.view.frame.origin.y = 0
            }
        }
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

