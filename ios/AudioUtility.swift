import AVFoundation

@objc(AudioUtility)
public class AudioUtility: NSObject {
    private static let MINIMAL_VOLUME_THRESHOLD: Float = 0.0

    @objc
    public static func isSoundOn() -> NSNumber? {
        let session = AVAudioSession.sharedInstance()

        do {
            try session.setCategory(
                .ambient,
                mode: .default,
                options: [.mixWithOthers]
            )
            try session.setActive(true)

            return NSNumber(
                value: session.outputVolume > MINIMAL_VOLUME_THRESHOLD
            )
        } catch {
            return nil
        }
    }
}
